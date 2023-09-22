package com.star.demo;

import com.star.dao.BookDao;
import com.star.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookDao bookDao = (BookDao)ctx.getBean("bookDao");
        bookDao.save();

        BookService bookService = ctx.getBean(BookService.class);
        bookService.save();
    }
}
