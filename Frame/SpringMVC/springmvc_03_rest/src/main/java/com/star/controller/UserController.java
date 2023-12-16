package com.star.controller;

import com.star.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String add(@RequestBody User user){
        System.out.println(user + " add...");
        return "{'user':'zhangsan'}";
    }

    @GetMapping("/{id}")
    public String  findUser(@PathVariable int id){
        System.out.println("finduser.." + id);
        return "{'user':'zhangsan'}";
    }

    @DeleteMapping("/{id}")
    public String  delete(@PathVariable int id){
        System.out.println("deleter..." + id);
        return "{'user':'zhangsan'}";
    }

    @PutMapping
    public String update(@RequestBody List<User> users){
        System.out.println(users + " update..");
        return "{'user':'zhangsan'}";
    }
}
