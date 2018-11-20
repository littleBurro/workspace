package com.example.helloserviceapi.service;

import com.example.helloserviceapi.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {

    @GetMapping("/hello/hello4")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello/hello5")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello/hello6")
    String hello(@RequestBody User user);
}
