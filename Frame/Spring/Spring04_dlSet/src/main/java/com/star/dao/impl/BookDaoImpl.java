package com.star.dao.impl;

import com.star.dao.BookDao;

public class BookDaoImpl implements BookDao{

    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public void save() {
        System.out.println("dao...." + name + "  " + age);
    }
}
