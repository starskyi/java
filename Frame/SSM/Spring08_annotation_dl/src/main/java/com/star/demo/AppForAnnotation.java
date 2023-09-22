package com.star.demo;

import com.star.config.SpringConfig;
import com.star.dao.BookDao;
import com.star.service.BookService;
import com.star.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookService = ctx.getBean(BookServiceImpl.class);
        bookService.save();
    }
}
