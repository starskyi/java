// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CategoryDaoImpl.java

package cn.itcast.travel.dao.inpl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryDaoImpl
    implements CategoryDao
{

    public CategoryDaoImpl()
    {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    public List findAll()
    {
        String sql = "select * from category";
        List list = template.query(sql, new BeanPropertyRowMapper(Category.class));
        return list;
    }

    JdbcTemplate template;
}
