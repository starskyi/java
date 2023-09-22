// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FindLoginUserServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.util.ResponseUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class FindLoginUserServlet extends HttpServlet
{

    public FindLoginUserServlet()
    {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        ResponseUtils.response(user, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        super.doPost(req, resp);
    }
}
