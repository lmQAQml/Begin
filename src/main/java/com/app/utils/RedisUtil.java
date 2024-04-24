package com.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 指定key设置过期时间
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0)
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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

    /**
     * 使用setIfAbsent()方法实现锁
     *
     * @param key
     * @param expireTime
     * @return
     */
    public Boolean setNX(String key, String expireTime) {
        // 锁不存在，创建即可
        if (redisTemplate.opsForValue().setIfAbsent(key, expireTime)) {
            return true;
        }
        // 判断所是否过期
        if (!ObjectUtils.isEmpty(expireTime) && Long.parseLong(expireTime) < System.currentTimeMillis()) {
            String oldTime = (String) redisTemplate.opsForValue().getAndSet(key, expireTime);
            return !ObjectUtils.isEmpty(oldTime) && Objects.equals(oldTime, expireTime);
        }
        return false;
    }

    /**
     * 实现分布式锁
     *
     * @param key
     * @param expireTime
     * @return
     */
    public Boolean setNX(String key, String value, long expireTime) {
        // 锁不存在
        if (redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS)) {
            return true;
        }
        return false;
    }

    /**
     * 释放锁
     * @param keys
     * @return
     */
    @SuppressWarnings("unchecked")
    public void delLock(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys);
            }
            redisTemplate.delete(keys);
        }
    }

    /**
     * 解决重复消费问题(未保证原子性), 配合定时任务
     * 分数存时间戳+过期时间
     * @return
     */
    public Boolean storeMessageInfo(String key, String value, double time) {
        Boolean hasAdd = redisTemplate.opsForZSet().add(key, value, time);
        return hasAdd;
    }


}