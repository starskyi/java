package com.star.demo;

import com.star.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println(ds);
    }
}
