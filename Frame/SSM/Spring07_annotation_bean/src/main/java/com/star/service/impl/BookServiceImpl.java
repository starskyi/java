package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    public void save() {
        System.out.println("service");
    }


}
