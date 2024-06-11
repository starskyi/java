package com.star.dao;


import com.star.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BookDao {

    @Select("select * from books")
    public List<Book> findAll();
}
