package com.app;

import com.app.entity.UserEntity;
import com.app.mapper.UserCacheMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    UserCacheMapper userCacheMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public static ThreadLocal<UserEntity> threadLocal1 = new ThreadLocal<>();

    public static ThreadLocal<UserEntity> threadLocal2 = new ThreadLocal<>();

    @Test
    void contextLoads() {
    }

    @Test
    void test_findList() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<UserEntity> re = userCacheMapper.findList(ids);
        System.out.println(re);
    }

    /**
     * thread使用示例
     */
    @Test
    void testThreadLocal() {

        UserEntity user1 = UserEntity.builder().id(1).userName("test").password("123456").build();
        threadLocal1.set(user1);

        UserEntity user2 = UserEntity.builder().id(2).userName("test2").password("15191232").build();
        threadLocal2.set(user2);

        System.out.println(threadLocal1.get());
        System.out.println(threadLocal2.get());

        threadLocal1.remove();
        threadLocal2.remove();
        System.out.println(threadLocal1.get());
        System.out.println(threadLocal2.get());
    }

    @Test
    @Async("myTestThreadPoolConfig")
    void TestThreadPool() {
        System.out.println("CPU核数: " + Runtime.getRuntime().availableProcessors());
        try {
            // 业务异步执行
            CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
                redisTemplate.opsForList().leftPush("线程", "线程1");
                return 1;
            });
            CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
                redisTemplate.opsForList().leftPush("线程", "线程2");
                return 2;
            });
            CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
                redisTemplate.opsForList().leftPush("线程", "线程3");
                return 3;
            });
            CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
                redisTemplate.opsForList().leftPush("线程", "线程4");
                return 4;
            });
            CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
                redisTemplate.opsForList().leftPush("线程", "线程5");
                return 5;
            });

            CompletableFuture.allOf(future1, future2, future3, future4, future5).get(3, TimeUnit.SECONDS);

            System.out.println(Arrays.asList(future1.get(), future2.get(), future3.get(), future4.get(), future5.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(redisTemplate.opsForList().range("线程", 0, -1));
    }
}
