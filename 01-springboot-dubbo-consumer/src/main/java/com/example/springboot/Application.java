package com.example.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration //开启对Dubbo的配置支持
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
