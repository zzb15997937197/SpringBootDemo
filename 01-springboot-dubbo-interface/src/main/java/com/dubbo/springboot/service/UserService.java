package com.dubbo.springboot.service;

import com.dubbo.springboot.mode.User;

/**
 * Created by admin on 2019/3/22.
 */
public interface UserService {
    public String sayHai(String name);

    public User getUser(Integer id);
}
