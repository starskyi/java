// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RegisterServlet.java

package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.ResponseUtils;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet extends HttpServlet
{

    public RegisterServlet()
    {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
