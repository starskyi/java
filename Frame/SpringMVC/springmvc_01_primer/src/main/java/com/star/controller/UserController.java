package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String sava(){
        System.out.println("user save..");
        return "{'user':'zhangsan'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        return "{'delete':'yes'}";
    }
}
