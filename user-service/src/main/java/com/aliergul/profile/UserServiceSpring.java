package com.aliergul.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
/**
 * Spring Cloud Feign aktivasyon
 */

public class UserServiceSpring {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceSpring.class);
    }
}

