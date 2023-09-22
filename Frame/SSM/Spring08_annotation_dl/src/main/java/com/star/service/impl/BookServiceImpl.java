package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;

    public void save() {
        bookDao.save();
        System.out.println("service");
    }


}
