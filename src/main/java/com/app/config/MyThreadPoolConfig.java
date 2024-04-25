package com.app.config;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync
public class MyThreadPoolConfig {

    @Value("${thread.pool.corePoolSize}")
    private int corePoolSize;

    @Value("${thread.pool.maxPoolSize}")
    private int maxPoolSize;

    @Value("${thread.pool.queueCapacity}")
    private int queueCapacity;

    @Value("${thread.pool.keepAliveSeconds}")
    private long keepAliveSeconds;

    @Bean
    public ThreadPoolExecutor myTestThreadPoolConfig() {
        return new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveSeconds,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
