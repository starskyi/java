// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FavoriteServiceImpl.java

package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.inpl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

public class FavoriteServiceImpl
    implements FavoriteService
{

    public FavoriteServiceImpl()
    {
        dao = new FavoriteDaoImpl();
    }

    public boolean isFavorite(String ridStr, int uid)
    {
        int rid = 0;
        try
        {
            rid = Integer.parseInt(ridStr);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Favorite favorite = null;
        try
        {
            favorite = dao.findByRidAndUid(rid, uid);
        }
        catch(Exception exception) { }
        return favorite != null;
    }

    public boolean addFavorite(String ridStr, int uid)
    {
        int rid = 0;
        try
        {
            rid = Integer.parseInt(ridStr);
        }
        catch(Exception exception) { }
        if(rid != 0)
        {
            dao.add(rid, uid);
            return true;
        } else
        {
            return false;
        }
    }

    FavoriteDao dao;
}
