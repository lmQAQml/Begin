package com.app.controller;

import com.app.entity.UserEntity;
import com.app.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class LoginController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/user/{id}")
    public Object checkUserCahe(@PathVariable("id") String id) {
        return redisUtil.getKey("user_" + id);
    }

}
