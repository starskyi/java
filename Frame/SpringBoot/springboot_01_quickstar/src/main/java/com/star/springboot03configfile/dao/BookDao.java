package com.star.springboot03configfile.dao;


import com.star.springboot03configfile.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BookDao {

    @Select("select * from books")
    public List<Book> findAll();
}
