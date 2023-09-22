// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PageBean.java

package cn.itcast.travel.domain;

import java.util.List;

public class PageBean
{

    public PageBean()
    {
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(int nowPage)
    {
        this.nowPage = nowPage;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public List getList()
    {
        return list;
    }

    public void setList(List list)
    {
        this.list = list;
    }

    public String toString()
    {
        return (new StringBuilder()).append("PageBean{totalCount=").append(totalCount).append(", totalPage=").append(totalPage).append(", nowPage=").append(nowPage).append(", pageSize=").append(pageSize).append(", list=").append(list).append('}').toString();
    }

    private int totalCount;
    private int totalPage;
    private int nowPage;
    private int pageSize;
    private List list;
}
