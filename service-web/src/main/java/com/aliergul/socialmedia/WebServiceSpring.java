package com.aliergul.socialmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebServiceSpring {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceSpring.class, args);
    }
}
