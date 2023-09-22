package com.star.demo;

import com.star.dao.OrderDao;
import com.star.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao)ctx.getBean("userDao");
        userDao.run();
    }
}
