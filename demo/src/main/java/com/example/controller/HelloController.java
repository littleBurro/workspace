package com.example.controller;

import com.example.helloserviceapi.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping(value = "/world")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(value = "/hello1")
    public String hello1(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping(value = "/hello2")
    public User hello2(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @PostMapping(value = "/hello3")
    public String hello3(@RequestBody User user){
        return "Hello " + user.getUserName() + ", " + user.getAge();
    }
}
