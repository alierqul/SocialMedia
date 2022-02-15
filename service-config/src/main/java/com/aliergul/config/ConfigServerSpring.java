package com.aliergul.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerSpring {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerSpring.class, args);
    }
}
