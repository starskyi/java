package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.dao.UserDao;
import com.star.service.BookService;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;
    private UserDao userDao;
    public void save() {
        bookDao.save();
        userDao.run();
        System.out.println("service");
    }

    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
}
