package com.alibaba.edsa.boot;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/15
 */
@RestController
public class DemoConsumerController {
    @Reference
    IHelloService iHelloService;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name")String name){
        return iHelloService.sayHello(name);
    }
}
