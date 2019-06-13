package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/4/28
 */


@RestController
public class UserController {

    @Value("$(user.name)")
    private String name;
    //通过主键来查询用户

    @RequestMapping("/boot/user")
    public void selectByPrimaryKey() {


    }


}
