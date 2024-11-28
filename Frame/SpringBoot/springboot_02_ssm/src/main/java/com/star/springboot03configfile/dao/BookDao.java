package com.star.springboot03configfile.dao;

import com.star.springboot03configfile.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    @Insert("insert into books(type, name, description) values(#{type}, #{name}, #{description})")
    int add(Book book);

    @Delete("delete from books where id = #{id}")
    int delete(int id);

    @Select("select * from books where id = #{id}")
    Book findById(int id);

    @Select("select * from books")
    List<Book> findAll();

    @Update("update books set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    int update(Book book);

}
