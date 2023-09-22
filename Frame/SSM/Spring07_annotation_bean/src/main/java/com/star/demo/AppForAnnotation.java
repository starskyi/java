package com.star.demo;

import com.star.config.SpringConfig;
import com.star.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
    }
}
