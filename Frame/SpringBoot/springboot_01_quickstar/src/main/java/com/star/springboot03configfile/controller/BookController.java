package com.star.springboot03configfile.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String save(){
        System.out.println("books save....");
        return "books save...";
    }
}
