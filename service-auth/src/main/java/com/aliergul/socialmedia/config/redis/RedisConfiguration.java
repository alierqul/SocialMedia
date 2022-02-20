package com.aliergul.socialmedia.config.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfiguration {
    private String server;
    private String port;


}
