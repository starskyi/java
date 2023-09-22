// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.ResponseUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

// Referenced classes of package cn.itcast.travel.web.servlet:
//            BaseServlet
@WebServlet("/user/*")
public class UserServlet extends BaseServlet
{

    public UserServlet()
    {
    }

    public void register(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        String check = req.getParameter("check");
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check))
        {
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("\u9A8C\u8BC1\u7801\u9519\u8BEF");
            ResponseUtils.response(info, resp);
            return;
        }
        UserService service = new UserServiceImpl();
        String username = req.getParameter("username");
        User findUser = null;
        try
        {
            findUser = service.findByName(username);
        }
        catch(Exception exception) { }
        if(findUser == null)
        {
            Map map = req.getParameterMap();
            String birthday = req.getParameter("birthday");
            User user = new User();
            try
            {
                BeanUtils.populate(user, map);
            }
            catch(Exception exception1) { }
            if(birthday.length() == 0)
                user.setBirthday(null);
            boolean flag = false;
            try
            {
                flag = service.register(user);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            ResultInfo info = new ResultInfo();
            if(flag)
            {
                info.setFlag(true);
            } else
            {
                info.setFlag(false);
                info.setErrorMsg("\u6CE8\u518C\u5931\u8D25");
            }
            ResponseUtils.response(info, resp);
        } else
        {
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("\u60A8\u6765\u665A\u4E86\uFF0C\u8BE5\u7528\u6237\u540D\u5DF2\u88AB\u6CE8\u518C");
            ResponseUtils.response(info, resp);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp)
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

    public void getUser(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        ResponseUtils.response(user, resp);
    }

    public void activeUser(HttpServletRequest req, HttpServletResponse resp)
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

    public void exit(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        req.getSession().invalidate();
        resp.sendRedirect((new StringBuilder()).append(req.getContextPath()).append("/login.html").toString());
    }
}
