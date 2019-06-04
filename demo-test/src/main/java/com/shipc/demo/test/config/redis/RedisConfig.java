package com.shipc.demo.test.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RedisConfig
 * @Description
 * @Author shipc
 * @Date 2019/5/23 19:45
 * @Version 1.0
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;
}
