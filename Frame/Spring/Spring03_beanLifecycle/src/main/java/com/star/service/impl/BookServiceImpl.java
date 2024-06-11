package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    private BookDao bookDao;

    public void save() {
        bookDao.save();
        System.out.println("service");
    }

    public void setBookDao(BookDao bookDao){
        System.out.println("set Dao");
        this.bookDao = bookDao;
    }
    public void init(){
        System.out.println("init");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy");
    }
}
