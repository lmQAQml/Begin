package com.app.service.impl;

import com.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 模板服务
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Async("myTestThreadPoolConfig")
    public void testAsync() {
        System.out.println("CPU核数: " + Runtime.getRuntime().availableProcessors());
        try {
            // 业务异步执行
            CompletableFuture<Long> future1 = CompletableFuture.supplyAsync(() -> {
                return redisTemplate.opsForList().leftPush(1, "顺序1");
            });
            CompletableFuture<Long> future2 = CompletableFuture.supplyAsync(() -> {
                return redisTemplate.opsForList().leftPush(2, "顺序2");
            });
            CompletableFuture<Long> future3 = CompletableFuture.supplyAsync(() -> {
                return redisTemplate.opsForList().leftPush(3, "顺序3");
            });
            CompletableFuture<Long> future4 = CompletableFuture.supplyAsync(() -> {
                return redisTemplate.opsForList().leftPush(4, "顺序4");
            });
            CompletableFuture<Long> future5 = CompletableFuture.supplyAsync(() -> {
                return redisTemplate.opsForList().leftPush(5, "顺序5");
            });

            CompletableFuture.allOf(future1, future2, future3, future4, future5).get(3, TimeUnit.SECONDS);

            System.out.println(Arrays.asList(future1.get(), future2.get(), future3.get(), future4.get(), future5.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
