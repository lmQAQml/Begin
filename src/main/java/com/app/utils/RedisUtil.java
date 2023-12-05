package com.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 指定key设置过期时间
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 获取指定区域的缓存
     *
     * @param area
     */
    public List<String> getAllKeys(String area) {
        Set<String> keys = redisTemplate.keys(area + "_*");
        if (Objects.isNull(keys) || keys.isEmpty()) {
            return null;
        }
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 根绝key获取（opsForValue）
     *
     * @param key
     * @return
     */
    public Object getKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean setNX(String key, String expireTime) {
        // 锁不存在，创建即可
        if (redisTemplate.opsForValue().setIfAbsent(key, expireTime)) {
            return true;
        }
        // 判断所是否过期
        if (!ObjectUtils.isEmpty(expireTime) && Long.parseLong(expireTime) < System.currentTimeMillis()) {
            String oldTime = redisTemplate.opsForValue().getAndSet(key, expireTime);
            return !ObjectUtils.isEmpty(oldTime) && Objects.equals(oldTime, expireTime);
        }
        return false;
    }

}
