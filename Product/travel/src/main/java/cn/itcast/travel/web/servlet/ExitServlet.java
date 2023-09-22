// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExitServlet.java

package cn.itcast.travel.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ExitServlet extends HttpServlet
{

    public ExitServlet()
    {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.getSession().invalidate();
        resp.sendRedirect((new StringBuilder()).append(req.getContextPath()).append("/login.html").toString());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
