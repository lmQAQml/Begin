package com.app;

import com.app.entity.UserEntity;
import com.app.mapper.UserCacheMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    UserCacheMapper userCacheMapper;

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

}
