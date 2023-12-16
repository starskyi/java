package com.star.controller;

import com.star.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    @ResponseBody
    public String add(String username, int age){
        System.out.println(username + "==>" + age);
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String del(@RequestParam("username")String name, int age){
        System.out.println(name + "==>" + age);
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/user")
    @ResponseBody
    public String find(User user){
        System.out.println(user);
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/array")
    @ResponseBody
    public String array(String[] ids){
        System.out.println(Arrays.toString(ids));
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(@RequestParam List<String> ids){
        System.out.println(ids);
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/arrayForJson")
    @ResponseBody
    public String arrayForJson(@RequestBody String[] names){
        System.out.println(Arrays.toString(names));
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/pojoForJson")
    @ResponseBody
    public String pojoForJson(@RequestBody User user){
        System.out.println(user);
        return "{'user','zhangsan'}";
    }

    @RequestMapping("/listForJson")
    @ResponseBody
    public String listForJson(@RequestBody List<User> users){
        System.out.println(users);
        return "{'user','zhangsan'}";
    }

    @RequestMapping(value = "/dateParam", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String dateParam(Date date, @DateTimeFormat(pattern="yyyy-MM-dd") Date date2,
                            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date3){
        System.out.println(date);
        System.out.println(date2);
        System.out.println(date3);
        return "{'user','张三'}";
    }

    @RequestMapping("/pojoJsonResponse")
    @ResponseBody
    public User pojoForJson(){
        User user = new User("李四", 33);
        return user;
    }

    @RequestMapping("/listJsonResponse")
    @ResponseBody
    public List<User> listForJson(){
        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan", 34));
        users.add(new User("lisi", 44));
        return users;
    }
}
