// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Category.java

package cn.itcast.travel.domain;

import java.io.Serializable;

public class Category
    implements Serializable
{

    public Category()
    {
    }

    public Category(int cid, String cname)
    {
        this.cid = cid;
        this.cname = cname;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Category{cid=").append(cid).append(", cname='").append(cname).append('\'').append('}').toString();
    }

    public int getCid()
    {
        return cid;
    }

    public void setCid(int cid)
    {
        this.cid = cid;
    }

    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    private int cid;
    private String cname;
}
