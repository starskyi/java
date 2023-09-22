package com.star.mapper;

import com.star.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findById(int id);

    void add(User user);

    void update(User user);

    void deleteByIds(@Param("ids")int[] ids);
}
