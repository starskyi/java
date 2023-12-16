package com.star.service.impl;

import com.star.dao.BookDao;
import com.star.domain.Book;
import com.star.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean add(Book book) {
        return bookDao.add(book) > 0;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id) > 0;
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }
}
