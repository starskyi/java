<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.star.dao.*"  %>
<%@ page import="java.sql.*" %>
<%@ page import="com.star.domain.*" %>
<%@ page import="com.star.utils.ResponseUtil" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login-b.jsp' starting page</title>
    

  </head>
  
  <body>
    <%
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
					Integer manager = Integer.parseInt(resultSet.getString(4));
					User user = new User(username, password, manager);
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
		
     %>
  </body>
</html>
