package com.soen343.gms.service;

import com.soen343.gms.model.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    List<User> findAll();
    void saveUser(User user);
}
