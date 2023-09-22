// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ActiveUserServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ActiveUserServlet extends HttpServlet
{

    public ActiveUserServlet()
    {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");
        if(code != null && code.length() > 0)
        {
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            String msg = null;
            if(flag)
                msg = "<a href='login.html'>\u6FC0\u6D3B\u6210\u529F\uFF0C\u8BF7\u767B\u5F55</a>";
            else
                msg = "\u6FC0\u6D3B\u5931\u8D25\uFF0C\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458";
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
