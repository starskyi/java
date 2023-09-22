package com.star.mapper;

import com.star.domain.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("select * from tb_admin where username = #{username} and password = #{password}")
    Admin selectAdmin(Admin admin);
}
