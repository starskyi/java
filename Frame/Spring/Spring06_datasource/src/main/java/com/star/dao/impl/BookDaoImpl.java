package com.star.dao.impl;

import com.star.dao.BookDao;

public class BookDaoImpl implements BookDao{

    private String username;
    public void save() {
        System.out.println("dao...." + username);
    }
    public void setUsername(String username){
        this.username = username;
    }
}
