package com.star.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {

    @Insert("insert into tb_log(info,createData) values(#{info}, now())")
    void log(String info);
}
