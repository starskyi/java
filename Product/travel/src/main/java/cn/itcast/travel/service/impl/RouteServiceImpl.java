// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteServiceImpl.java

package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.inpl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

public class RouteServiceImpl
    implements RouteService
{

    public RouteServiceImpl()
    {
        dao = new RouteDaoImpl();
    }

    public PageBean pageQuery(int cid, int nowPage, int pageSize, String rname)
    {
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        int totalCount = dao.findTotalCount(cid, rname);
        pageBean.setTotalCount(totalCount);
        int totalPage = totalCount % pageSize != 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
        if(totalPage < 1)
            totalPage = 1;
        pageBean.setTotalPage(totalPage);
        if(nowPage < 1)
        {
            pageBean.setNowPage(1);
            nowPage = 1;
        } else
        if(nowPage > totalPage)
        {
            pageBean.setNowPage(totalPage);
            nowPage = totalPage;
        } else
        {
            pageBean.setNowPage(nowPage);
        }
        int star = (nowPage - 1) * pageSize;
        java.util.List list = dao.findAll(cid, star, pageSize, rname);
        pageBean.setList(list);
        return pageBean;
    }

    public Route findOne(int rid)
    {
        Route route = dao.findOne(rid);
        java.util.List routeImg = dao.findRouteImg(rid);
        route.setRouteImgList(routeImg);
        int sid = route.getSid();
        cn.itcast.travel.domain.Seller seller = dao.findSeller(sid);
        route.setSeller(seller);
        int count = dao.findCollectCount(rid);
        route.setCount(count);
        return route;
    }

    RouteDao dao;
}
