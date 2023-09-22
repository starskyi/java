package com.star.mapper;

import com.star.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb_user")
    List<User> findAll();

    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);


    void add(User user);

    int update(User user);

    @Select("select * from tb_user where isMerchant = #{status}")
    List<User> selectByStatus(int status);

    @Delete("delete from tb_user where username = #{username}")
    void delByUsername(String username);

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User findUser(@Param("username")String username, @Param("password")String password);

}
