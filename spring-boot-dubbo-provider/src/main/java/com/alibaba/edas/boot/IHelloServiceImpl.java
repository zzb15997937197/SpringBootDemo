package com.alibaba.edas.boot;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @description:
 * @version: 1.0
 * @author: zhengbing.zhang@hand-china.com
 * @Date: 2019/5/15
 */

@Service
public class IHelloServiceImpl implements IHelloService {
    public String sayHello(String name) {
        return "Hello,"+name+"(from dubbo with springboot)";
    }
}
