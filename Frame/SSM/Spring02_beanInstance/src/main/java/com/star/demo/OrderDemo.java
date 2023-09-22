package com.star.demo;

import com.star.dao.OrderDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        OrderDao orderDao = (OrderDao)ctx.getBean("orderDao");
        orderDao.order();
    }
}
