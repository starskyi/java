// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteImg.java

package cn.itcast.travel.domain;

import java.io.Serializable;

public class RouteImg
    implements Serializable
{

    public RouteImg()
    {
    }

    public RouteImg(int rgid, int rid, String bigPic, String smallPic)
    {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getRgid()
    {
        return rgid;
    }

    public void setRgid(int rgid)
    {
        this.rgid = rgid;
    }

    public int getRid()
    {
        return rid;
    }

    public void setRid(int rid)
    {
        this.rid = rid;
    }

    public String getBigPic()
    {
        return bigPic;
    }

    public void setBigPic(String bigPic)
    {
        this.bigPic = bigPic;
    }

    public String getSmallPic()
    {
        return smallPic;
    }

    public void setSmallPic(String smallPic)
    {
        this.smallPic = smallPic;
    }

    private int rgid;
    private int rid;
    private String bigPic;
    private String smallPic;
}
