package com.app.service.impl;

import com.app.entity.UserEntity;
import com.app.mapper.UserCacheMapper;
import com.app.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
@Service
public class ICacheServiceImpl implements ICacheService {

    private static String prefix = "user_";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserCacheMapper userCacheMapper;

    @Override
    public void initUserCacheList() {
        List<UserEntity> list = userCacheMapper.initUserCacheList();
        log.info("即将缓存的数据:{}", list);

        if (list.isEmpty()) {
            return;
        }
        // 缓存加载时间
        log.info("缓存开始加载时间:{}", System.currentTimeMillis());
        // 两种执行方式, 自行选择
//        toFor(list);
        toThreadPool(list);
    }

    /**
     * 1.对数据不多的情况下可使用轮次存入
     *
     * @param list
     */
    private void toFor(List<UserEntity> list) {

        for (UserEntity user : list) {
            if (Objects.isNull(user) || Objects.isNull(user.getUserName())) {
                continue;
            }
            redisTemplate.opsForValue().set(prefix + user.getId(), user, 60 * 60, TimeUnit.SECONDS);
        }
    }

    /**
     * 2.数据多的情况可使用多线程加载，通过创建Executor实现
     *
     * @param list
     */
    private void toThreadPool(List<UserEntity> list) {

        // 对list拆分,每个list处理100条数据
        int listSize = 100;
        List<List<UserEntity>> totalList = new ArrayList<>();
        for (int i = 0; i <= list.size(); i += listSize) {
            totalList.add(list.subList(i, Math.min(i + listSize, list.size())));
        }
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 30,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < totalList.size(); i++) {
            List<UserEntity> sonList = totalList.get(i);
            if (Objects.isNull(sonList)) {
                break;
            }
            poolExecutor.execute(() -> doData(sonList));
        }

    }

    public void doData(List<UserEntity> list) {
        for (UserEntity userEntity : list) {
            if (userEntity.getId() == null) {
                continue;
            }
            String key = prefix + userEntity.getId();
            redisTemplate.opsForValue().set(key, userEntity, 60 * 60, TimeUnit.SECONDS);
        }
    }


}
