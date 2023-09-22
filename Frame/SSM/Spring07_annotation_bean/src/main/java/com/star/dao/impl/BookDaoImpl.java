package com.star.dao.impl;

import com.star.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao{

    public void save() {
        System.out.println("dao....");
    }


}