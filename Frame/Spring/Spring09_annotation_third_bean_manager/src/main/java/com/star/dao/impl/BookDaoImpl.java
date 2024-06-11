package com.star.dao.impl;

import com.star.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao{
    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    public void save() {
        System.out.println("dao...." + name + " " + age);
    }


}