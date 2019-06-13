package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

/**
 * Created by admin on 2019/3/22.
 */

public interface UserService {
    public List<User> getAllUsers();

    public int update(Integer id, String name);
}
