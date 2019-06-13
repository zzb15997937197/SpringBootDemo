package com.example.springboot.controller;

import com.example.springboot.model.ConfigUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/3
 */
@RestController
public class HelloController {


    @Value("${boot.name}")
    private String name;

    @Value("${boot.location}")
    private String location;

    @Autowired
    ConfigUser configUser;

    @RequestMapping("/boot/config")
    public String user() {
        System.out.println(configUser.getLocation() + "-" + configUser.getName());
        return "您好,上海！" + name + "-" + location;
    }


}
