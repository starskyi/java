package com.star.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public void findAll(){
        System.out.println("findAll.....");
    }
}
