package com.star.springboot03configfile;

import com.star.springboot03configfile.dao.BookDao;
import com.star.springboot03configfile.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01QuickstarApplicationTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Test
    public void save() {
        System.out.println(bookDao.findAll());
    }
}
