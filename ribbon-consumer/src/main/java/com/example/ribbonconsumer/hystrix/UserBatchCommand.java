package com.example.ribbonconsumer.hystrix;

import com.example.ribbonconsumer.service.UserService;
import com.example.userserver.model.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.List;

public class UserBatchCommand extends HystrixCommand<List<User>> {

    UserService userService;

    List<Long> ids;

    public UserBatchCommand(UserService userService, List<Long> ids){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userServiceCommand")));
        this.ids = ids;
        this.userService = userService;
    }

    @Override
    protected List<User> run() throws Exception {
        return userService.findAll(ids);
    }
}
