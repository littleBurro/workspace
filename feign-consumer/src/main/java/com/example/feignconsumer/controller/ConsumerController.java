package com.example.feignconsumer.controller;

import com.example.feignconsumer.service.DomeService;
import com.example.feignconsumer.service.RefactorHelloService;
import com.example.helloserviceapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    DomeService domeService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @GetMapping(value = "/feign-consumer")
    public String helloConsumer(){
        return domeService.hello();
    }

    @GetMapping(value = "/feign-consumer2")
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(domeService.hello()).append("\n");
        sb.append(domeService.hello("DIDI")).append("\n");
        sb.append(domeService.hello("DIDI", 30)).append("\n");
        sb.append(domeService.hello(new User("DADA", 20))).append("\n");
        return sb.toString();
    }

    @GetMapping(value = "/feign-consumer3")
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")).append("\n");
        sb.append(refactorHelloService.hello("MIMI", 30)).append("\n");
        sb.append(refactorHelloService.hello(new User("MAMA", 20))).append("\n");
        return sb.toString();
    }
}
