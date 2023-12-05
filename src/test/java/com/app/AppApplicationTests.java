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

    @Test
    void contextLoads() {
    }

    @Test
    void test_findList() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<UserEntity> re = userCacheMapper.findList(ids);
        System.out.println(re);
    }
}
