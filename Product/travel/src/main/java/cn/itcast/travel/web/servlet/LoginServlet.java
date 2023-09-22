// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.ResponseUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

public class LoginServlet extends HttpServlet
{

    public LoginServlet()
    {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        Map map = req.getParameterMap();
        User user = new User();
        try
        {
            BeanUtils.populate(user, map);
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(InvocationTargetException e)
        {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        User u = service.login(user);
        ResultInfo info = new ResultInfo();
        if(u == null)
        {
            info.setFlag(false);
            info.setErrorMsg("\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF");
        }
        if(u != null && !"Y".equals(u.getStatus()))
        {
            info.setFlag(false);
            info.setErrorMsg("\u8BE5\u7528\u6237\u5C1A\u672A\u6FC0\u6D3B\uFF0C\u8BF7\u6FC0\u6D3B");
        }
        if(u != null && "Y".equals(u.getStatus()))
        {
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            info.setFlag(true);
        }
        ResponseUtils.response(info, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
