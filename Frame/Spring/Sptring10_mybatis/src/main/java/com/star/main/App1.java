package com.star.main;

import com.star.config.SpringConfig;
import com.star.domain.User;
import com.star.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        List<User> users = userService.findAll();
        User user = userService.findUser(2);
        System.out.println(user);
        System.out.println(users);
    }
}
