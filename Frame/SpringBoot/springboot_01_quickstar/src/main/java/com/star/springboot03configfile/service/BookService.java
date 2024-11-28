package com.star.springboot03configfile.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void save(){
        System.out.println("bookservice.save");
    }
}
