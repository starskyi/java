package com.star.factory;

import com.star.dao.UserDao;
import com.star.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
