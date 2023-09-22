package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.dao.impl.BookDaoImpl;
import com.star.service.BookService;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public void save() {
        bookDao.save();
        System.out.println("service");
    }

    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }
}
