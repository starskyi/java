package com.star.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

    public void findAll();
    public int update(String name);
}
