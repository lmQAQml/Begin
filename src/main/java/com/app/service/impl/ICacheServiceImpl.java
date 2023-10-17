package com.app.service.impl;

import com.app.entity.UserEntity;
import com.app.mapper.UserCacheMapper;
import com.app.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
        for (UserEntity user : list) {
            if (Objects.isNull(user) || Objects.isNull(user.getUserName())) {
                continue;
            }
            redisTemplate.opsForValue().set(prefix + user.getId(), user, 60 * 60, TimeUnit.SECONDS);
        }
    }

}
