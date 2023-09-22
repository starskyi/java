package com.star.demo;

import com.star.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook();

        BookService bookService = (BookService)ctx.getBean("bookService");
        bookService.save();
        //ctx.close();
    }
}
