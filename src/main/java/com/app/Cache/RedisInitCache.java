package com.app.Cache;

import com.app.service.ICacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RedisInitCache implements ApplicationRunner {

    @Autowired
    private ICacheService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 加载User表缓存
        service.initUserCacheList();
        // 加载其他表缓存

    }
}
