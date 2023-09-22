// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FavoriteDao.java

package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao
{

    public abstract Favorite findByRidAndUid(int i, int j);

    public abstract void add(int i, int j);
}
