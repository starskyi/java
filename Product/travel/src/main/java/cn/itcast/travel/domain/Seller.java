// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Seller.java

package cn.itcast.travel.domain;

import java.io.Serializable;

public class Seller
    implements Serializable
{

    public Seller()
    {
    }

    public Seller(int sid, String sname, String consphone, String address)
    {
        this.sid = sid;
        this.sname = sname;
        this.consphone = consphone;
        this.address = address;
    }

    public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    public String getSname()
    {
        return sname;
    }

    public void setSname(String sname)
    {
        this.sname = sname;
    }

    public String getConsphone()
    {
        return consphone;
    }

    public void setConsphone(String consphone)
    {
        this.consphone = consphone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    private int sid;
    private String sname;
    private String consphone;
    private String address;
}
