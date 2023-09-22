// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserDaoImpl.java

package cn.itcast.travel.dao.inpl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import java.io.PrintStream;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl
    implements UserDao
{

    public UserDaoImpl()
    {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    public User findByName(String username)
    {
        String sql = "select * from user where username = ?";
        return (User)template.queryForObject(sql, new BeanPropertyRowMapper(User.class), new Object[] {
            username
        });
    }

    public int addUser(User user)
    {
        String sql = "insert into user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        int update = template.update(sql, new Object[] {
            user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail(), user.getStatus(), user.getCode()
        });
        return update;
    }

    public User findByCode(String code)
    {
        String sql = "select * from user where code = ?";
        User user = null;
        try
        {
            user = (User)template.queryForObject(sql, new BeanPropertyRowMapper(User.class), new Object[] {
                code
            });
        }
        catch(Exception e)
        {
            System.out.println("\u67E5\u8BE2\u5931\u8D25");
        }
        return user;
    }

    public void updateStatus(User user)
    {
        String sql = "update user set status = 'Y' where uid = ?";
        template.update(sql, new Object[] {
            Integer.valueOf(user.getUid())
        });
    }

    public User findByUser(User user)
    {
        String sql = "select * from user where username = ? and password = ?";
        User u = (User)template.queryForObject(sql, new BeanPropertyRowMapper(User.class), new Object[] {
            user.getUsername(), user.getPassword()
        });
        return u;
    }

    private JdbcTemplate template;
}
