package com.example.springboot;

import com.example.springboot.model.ConfigUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(ConfigUser.class)
public class SpringbootWebInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebInterceptorApplication.class, args);
    }

}
