package com.star.main;

import com.star.config.SpringConfig;
import com.star.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserDao userDao = ctx.getBean(UserDao.class);
        int count = userDao.update("zhangsan");
        System.out.println(count);
    }
}
