package com.example.userserver.UserService.impl;

import com.example.userserver.UserService.UserService;
import com.example.userserver.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User find(Long id) {
        logger.info("获取用户，id: {}", id);
        return new User(id);
    }

    @Override
    public List<User> findAll(List<String> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach((id) -> {
            logger.info("获取全部用户， ids: {}", id);
            users.add(new User(Long.parseLong(id)));
        });
        return users;
    }
}
