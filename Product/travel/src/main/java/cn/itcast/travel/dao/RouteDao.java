// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteDao.java

package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.Seller;
import java.util.List;

public interface RouteDao
{

    public abstract int findTotalCount(int i, String s);

    public abstract List findAll(int i, int j, int k, String s);

    public abstract Route findOne(int i);

    public abstract List findRouteImg(int i);

    public abstract Seller findSeller(int i);

    public abstract int findCollectCount(int i);
}
