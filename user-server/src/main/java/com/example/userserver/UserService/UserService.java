package com.example.userserver.UserService;

import com.example.userserver.model.User;

import java.util.List;

public interface UserService {

    User find(Long id);

    List<User> findAll(List<String> ids);
}
