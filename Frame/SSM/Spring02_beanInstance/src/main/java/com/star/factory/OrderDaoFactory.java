package com.star.factory;

import com.star.dao.OrderDao;
import com.star.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
