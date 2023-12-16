package com.star.dao.impl;

import com.star.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void findAll() {
        System.out.println("findUser");
    }

    @Override
    public int update(String name) {
        System.out.println("update user " + name);
        return 100;
    }
}
