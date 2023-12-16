package com.star.service;

import com.star.config.SpringConfig;
import com.star.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
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
