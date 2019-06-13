package com.example.springboot.service;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2019/3/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public /*synchronized*/ List<User> getAllUsers() {
        //使用字符的redis序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //查一下缓存,高并发环境下，会出现缓存穿透的问题,使用synchronized关键词解决高并发
        //双重检测锁
        /*
         1.使用redisTemplate获取值，如果没有的话，查找数据库
         2.调用selectAllUsers()方法查询到对象集合
         3.将所查到的对象集合存放到redis里面
         */
        List<User> userList = (List<User>) redisTemplate.opsForValue().get("allusers");

        if (null == userList) {
            //此时高并发会出现穿透现象，使用synchronized(this)来进行同步
            synchronized (this) {
                userList = (List<User>) redisTemplate.opsForValue().get("allusers");
                if (null == userList) {
                    userList = userMapper.selectAllUsers();
                    redisTemplate.opsForValue().set("allusers", userList);
                    System.out.println("查询的数据库！");
                } else {
                    System.out.println("查询的redis!");
                }
            }
        } else {
            System.out.println("查询的redis");
        }


//        if(null==userList){
//                //查寻一遍数据库,如果为空的话才查数据库
//                   System.out.println("查询的数据库!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    userList= userMapper.selectAllUsers();
//                    //再放到redis里面去
//                    redisTemplate.opsForValue().set("allUsers",userList);
//        }else{
//            System.out.println("查询的redis");
//        }

        return userList;
    }

    @Transactional
    @Override
    public int update(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setPassword("123456");
        int row = userMapper.updateByPrimaryKey(user);
        System.out.print("更新结果：" + row);
        //此处会抛出运行时异常，用@Transactional注解后，事务将会发生回滚，也就时说此方法将不会被调用
        // int a=10/0;
        return row;
    }
}
