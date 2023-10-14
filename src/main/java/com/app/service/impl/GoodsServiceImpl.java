package com.app.service.impl;

import com.app.param.LightningParam;
import com.app.service.GoodsService;
import com.app.utils.StringUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {


    @Override
    public String lightningDeal(LightningParam param) {
        // 分布式锁Redisson
        RLock lock = StringUtil.getBean(RedissonClient.class).getLock(param.getKey());
        Assert.isTrue(Objects.nonNull(lock), "商品不存在");
        boolean locked;
        try {

            // 设置锁的过期时间
            locked = lock.tryLock(0, param.getTime(), param.getTimeUnit());
            Assert.isTrue(locked, "商品已被抢光");
            // 业务代码
            log.info("锁信息:{}", Thread.currentThread().getId());
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 业务完成后判断当前锁的状态和持有者
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return null;
    }
}
