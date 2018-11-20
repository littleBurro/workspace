package com.example.feignconsumer.service;

import com.example.helloserviceapi.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 服务降级类
 */
@Service
public class DomeServiceFallback implements DomeService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("未知", 19);
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
