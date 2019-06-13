package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springboot.mapper")
@EnableTransactionManagement //开启事务支持
public class DemoApplication {

    public static void main(String[] args) {
        //启动springboot程序，启动内嵌tomcat
        SpringApplication.run(DemoApplication.class, args);
    }

}
