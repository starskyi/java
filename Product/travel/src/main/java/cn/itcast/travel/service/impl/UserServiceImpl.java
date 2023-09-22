// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserServiceImpl.java

package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.inpl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl
    implements UserService
{

    public UserServiceImpl()
    {
        dao = new UserDaoImpl();
    }

    public boolean register(User user)
    {
        String uuid = UuidUtil.getUuid();
        user.setCode(uuid);
        user.setStatus("N");
        int i = dao.addUser(user);
        if(i == 1)
        {
            String content = (new StringBuilder()).append("<a href='http://localhost:8080/travel/activeUser?code=").append(user.getCode()).append("'>\u70B9\u51FB\u6FC0\u6D3B\u3010\u9ED1\u9A6C\u65C5\u6E38\u7F51\u3011</a>").toString();
            MailUtils.sendMail(user.getEmail(), content, "\u6FC0\u6D3B\u90AE\u4EF6");
            return true;
        } else
        {
            return false;
        }
    }

    public User findByName(String name)
    {
        return dao.findByName(name);
    }

    public boolean active(String code)
    {
        User user = dao.findByCode(code);
        if(user != null)
        {
            dao.updateStatus(user);
            return true;
        } else
        {
            return false;
        }
    }

    public User login(User user)
    {
        User u = null;
        try
        {
            u = dao.findByUser(user);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return u;
    }

    private UserDao dao;
}
