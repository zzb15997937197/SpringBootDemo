package com.example.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/20
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String indexcontroller(Map<String,Object> result){
        System.out.println("sfljasldfjlkasjfkl");
        result.put("name","cd");
        result.put("sex",0);
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        result.put("userlist",list);
        return "index";
    }

}
