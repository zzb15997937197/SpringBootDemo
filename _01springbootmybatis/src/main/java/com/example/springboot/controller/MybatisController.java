package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/3/22.
 */

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @RequestMapping("/boot/user")
    public Object users() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                userService.getAllUsers();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10000; i++) {
            //假设有10000个用户过来访问
            executorService.submit(runnable);
        }
        List<User> users = userService.getAllUsers();
        System.out.print("查找成功！");
        return users;
    }


    //RestFull编程风格
    @RequestMapping("boot/user/{id}/{name}")
    public Object user(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setPassword("123456");
        user.setCreatedUser("zhuzhu");
        userService.update(id, name);
        return user;
    }

    @RequestMapping("boot/{name}/user/{id}")
    public Object user1(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setPassword("123456");
        userService.update(id, name);
        return user;
    }

//    @RequestMapping("boot/user/{name}/{id}")
//    public Object user2(@PathVariable("id")Integer id,@PathVariable("name")String name){
//        User user=new User();
//        user.setId(id);
//        user.setUsername(name);
//        user.setPassword("123456");
//        userService.update(id,name);
//        return user;
//    }


}
