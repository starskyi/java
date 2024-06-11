package com.star.demo;

import com.star.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
//        System.out.println(dataSource);
        BookDao bookDao = (BookDao)ctx.getBean("bookDao");
        bookDao.save();

    }
}
