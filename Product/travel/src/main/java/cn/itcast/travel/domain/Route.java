// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Route.java

package cn.itcast.travel.domain;

import java.io.Serializable;
import java.util.List;

// Referenced classes of package cn.itcast.travel.domain:
//            Category, Seller

public class Route
    implements Serializable
{

    public Route()
    {
    }

    public Route(int rid, String rname, double price, String routeIntroduce, String rflag, String rdate, 
            String isThemeTour, int count, int cid, String rimage, int sid, String sourceId)
    {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isThemeTour = isThemeTour;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceId = sourceId;
    }

    public List getRouteImgList()
    {
        return routeImgList;
    }

    public void setRouteImgList(List routeImgList)
    {
        this.routeImgList = routeImgList;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Seller getSeller()
    {
        return seller;
    }

    public void setSeller(Seller seller)
    {
        this.seller = seller;
    }

    public String getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(String sourceId)
    {
        this.sourceId = sourceId;
    }

    public int getRid()
    {
        return rid;
    }

    public void setRid(int rid)
    {
        this.rid = rid;
    }

    public String getRname()
    {
        return rname;
    }

    public void setRname(String rname)
    {
        this.rname = rname;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getRouteIntroduce()
    {
        return routeIntroduce;
    }

    public void setRouteIntroduce(String routeIntroduce)
    {
        this.routeIntroduce = routeIntroduce;
    }

    public String getRflag()
    {
        return rflag;
    }

    public void setRflag(String rflag)
    {
        this.rflag = rflag;
    }

    public String getRdate()
    {
        return rdate;
    }

    public void setRdate(String rdate)
    {
        this.rdate = rdate;
    }

    public String getIsThemeTour()
    {
        return isThemeTour;
    }

    public void setIsThemeTour(String isThemeTour)
    {
        this.isThemeTour = isThemeTour;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getCid()
    {
        return cid;
    }

    public void setCid(int cid)
    {
        this.cid = cid;
    }

    public String getRimage()
    {
        return rimage;
    }

    public void setRimage(String rimage)
    {
        this.rimage = rimage;
    }

    public int getSid()
    {
        return sid;
    }

    public void setSid(int sid)
    {
        this.sid = sid;
    }

    private int rid;
    private String rname;
    private double price;
    private String routeIntroduce;
    private String rflag;
    private String rdate;
    private String isThemeTour;
    private int count;
    private int cid;
    private String rimage;
    private int sid;
    private String sourceId;
    private Category category;
    private Seller seller;
    private List routeImgList;
}
