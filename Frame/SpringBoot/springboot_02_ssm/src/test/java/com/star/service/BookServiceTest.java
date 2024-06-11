package com.star.service;

import com.star.domain.Book;
import com.star.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void findByIdTest(){
        System.out.println(bookService.findById(1));
    }

    @Test
    public void addTest(){
        bookService.add(new Book(null, "计算机", "鸟哥的linux私房菜", "linux 不一样的操作系统"));
    }

}
