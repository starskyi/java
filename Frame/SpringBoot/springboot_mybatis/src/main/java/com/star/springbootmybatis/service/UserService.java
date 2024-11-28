package com.star.springbootmybatis.service;

import com.star.springbootmybatis.pojo.User;

public interface UserService {

    public User findById(Integer id);
}
