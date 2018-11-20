package com.example.ribbonconsumer.service;

import com.example.userserver.model.User;

import java.util.List;

public interface UserService {

    User find(Long id);

    List<User> findAll(List<Long> ids);
}
