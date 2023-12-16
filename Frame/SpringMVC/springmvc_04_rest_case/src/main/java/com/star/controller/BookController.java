package com.star.controller;


import com.star.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book){
        System.out.println(book);
        return "{'info', 'success'}";
    }

    @GetMapping
    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "计算机", "C++反汇编", "逆向分析与应用"));
        books.add(new Book(1, "计算机", "python人工智能", "引领新时代"));

        return books;
    }

}
