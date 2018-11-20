package com.example.feignconsumer.service;

import com.example.helloserviceapi.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "dome-service", fallback = DomeServiceFallback.class)
public interface DomeService {

    @RequestMapping("/hello/world")
    String hello();

    @GetMapping("/hello/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello/hello3")
    String hello(@RequestBody User user);
}
