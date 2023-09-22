// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserDao.java

package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao
{

    public abstract User findByName(String s);

    public abstract int addUser(User user);

    public abstract User findByCode(String s);

    public abstract void updateStatus(User user);

    public abstract User findByUser(User user);
}
