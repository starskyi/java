// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserService.java

package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService
{

    public abstract boolean register(User user);

    public abstract User findByName(String s);

    public abstract boolean active(String s);

    public abstract User login(User user);
}
