package com.star.demo;

import com.star.dao.BookDao;
import com.star.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");


        BookService bookService = (BookService)ctx.getBean("bookService");
        bookService.save();
    }
}
