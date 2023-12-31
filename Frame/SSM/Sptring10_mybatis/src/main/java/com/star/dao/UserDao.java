package com.star.dao;

import com.star.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id = ${id}")
    public User findById(int id);
}
