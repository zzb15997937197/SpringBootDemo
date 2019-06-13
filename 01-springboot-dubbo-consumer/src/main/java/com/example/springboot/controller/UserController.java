package com.example.springboot.controller;

import com.dubbo.springboot.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/5
 */
@Controller
public class UserController {

    @Reference  //使用dubbo注解@Reference来引用远程的dubbo服务
    private UserService userService;

    @RequestMapping("/sayHi")
    public @ResponseBody String sayHi() {
        return userService.sayHai("springboot dubbo....");
    }


}
