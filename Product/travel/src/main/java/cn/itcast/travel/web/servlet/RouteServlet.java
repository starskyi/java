// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import cn.itcast.travel.util.ResponseUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Referenced classes of package cn.itcast.travel.web.servlet:
//            BaseServlet

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet
{

    public RouteServlet()
    {
        service = new RouteServiceImpl();
    }

    public void pageQuery(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String cidStr = req.getParameter("cid");
        String nowPageStr = req.getParameter("nowPage");
        String pageSizeStr = req.getParameter("pageSize");
        String rname = req.getParameter("rname");
        if(rname != null && rname.length() > 0)
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        int cid = 5;
        if(cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr))
            cid = Integer.parseInt(cidStr);
        int nowPage = 1;
        if(nowPageStr != null && nowPageStr.length() > 0)
            nowPage = Integer.parseInt(nowPageStr);
        int pageSize = 5;
        if(pageSizeStr != null && pageSizeStr.length() > 0)
            pageSize = Integer.parseInt(pageSizeStr);
        cn.itcast.travel.domain.PageBean pageBean = service.pageQuery(cid, nowPage, pageSize, rname);
        ResponseUtils.response(pageBean, resp);
    }

    public void findOne(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String ridStr = req.getParameter("rid");
        int rid = 0;
        if(ridStr != null && ridStr.length() > 0 && !"null".equals(ridStr))
            rid = Integer.parseInt(ridStr);
        cn.itcast.travel.domain.Route route = service.findOne(rid);
        ResponseUtils.response(route, resp);
    }

    public void isFavorite(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        String rid = req.getParameter("rid");
        User user = (User)req.getSession().getAttribute("user");
        int uid = 0;
        if(user != null)
            uid = user.getUid();
        boolean flag = (new FavoriteServiceImpl()).isFavorite(rid, uid);
        ResponseUtils.response(Boolean.valueOf(flag), resp);
    }

    public void addFavorite(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        User user = (User)req.getSession().getAttribute("user");
        if(user == null)
        {
            ResponseUtils.response(Boolean.valueOf(false), resp);
            return;
        } else
        {
            String rid = req.getParameter("rid");
            int uid = user.getUid();
            boolean flag = (new FavoriteServiceImpl()).addFavorite(rid, uid);
            ResponseUtils.response(Boolean.valueOf(flag), resp);
            return;
        }
    }

    private RouteService service;
}
