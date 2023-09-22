// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Favorite.java

package cn.itcast.travel.domain;

import java.io.Serializable;

// Referenced classes of package cn.itcast.travel.domain:
//            Route, User

public class Favorite
    implements Serializable
{

    public Favorite()
    {
    }

    public Favorite(Route route, String date, User user)
    {
        this.route = route;
        this.date = date;
        this.user = user;
    }

    public Route getRoute()
    {
        return route;
    }

    public void setRoute(Route route)
    {
        this.route = route;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    private Route route;
    private String date;
    private User user;
}
