package com.star.service;

import com.star.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findUser(int id);
}
