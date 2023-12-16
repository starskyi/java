package com.star.servlet;

import com.star.dao.UserDao;
import com.star.domain.User;
import com.star.utils.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;


public class UserServlet extends BaseServlet{

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao userDao = new UserDao();
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResultSet resultSet = userDao.findUser(username, password);

        if(resultSet != null)
        {
            try{
                resultSet.next();
                if(username.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))){
                    //登录成功
                    Integer id = Integer.parseInt(resultSet.getString(1));
                    User user = new User(id,username, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    ResponseUtil.response(response, "1");
                }else{
                    //登录失败
                    ResponseUtil.response(response, "用户名或密码错误，请重新登录");
                }
            }catch(Exception e){
                //登录失败
                e.printStackTrace();
                ResponseUtil.response(response, "用户名或密码错误，请重新登录");

            }

        }
    }

    //注册
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao userDao = new UserDao();

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try{
            int flag = userDao.add(username, password);
            if(flag != 0){
                ResponseUtil.response(response, "1");
            }else{
                ResponseUtil.response(response, "注册失败,请重新注册");
            }
        }catch(Exception e){
            ResponseUtil.response(response, "注册失败,请重新注册");
            e.printStackTrace();
        }
    }

    //获取登录用户
    public void getUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String message = "";
        if(user != null){
            message = user.getUsername();
        }
        ResponseUtil.response(response, message);
    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("/login.html");
    }
}
