package com.star.springbootmybatis.service.impl;

import com.star.springbootmybatis.mapper.UserMapper;
import com.star.springbootmybatis.pojo.User;
import com.star.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
