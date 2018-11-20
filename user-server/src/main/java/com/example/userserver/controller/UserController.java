package com.example.userserver.controller;

import com.example.userserver.UserService.UserService;
import com.example.userserver.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/find/{id}")
    public User find(@PathVariable Long id){
        return userService.find(id);
    }

    @GetMapping(value = "/findAll")
    public List<User> findAll(String ids){
        return userService.findAll(Arrays.asList(StringUtils.split(ids, ",")));
    }
}
