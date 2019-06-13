package com.alibaba.edsa.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/15
 */
@SpringBootApplication
public class DubboConsumer {
    public static void main(String[]args){
        SpringApplication.run(DubboConsumer.class);
    }
}
