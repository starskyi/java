package com.star.dao;

import com.star.domain.Admin;
import com.star.mapper.AdminMapper;

import static com.star.ui.MainInterface.sqlSession;


public class AdminDao {
    AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

    public Admin selectAdmin(Admin admin){
        return mapper.selectAdmin(admin);
    }
}
