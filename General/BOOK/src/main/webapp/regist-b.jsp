<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.dao.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.star.utils.ResponseUtil" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist-b.jsp' starting page</title>
    

  </head>
  
  <body>
    <%
    	UserDao userDao = new UserDao();
    	
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String manager = request.getParameter("manager");

		try{
			Integer imanager = Integer.parseInt(manager);
			int flag = userDao.add(username, password, imanager);
			if(flag != 0){
				ResponseUtil.response(response, "1");
			}else{
				ResponseUtil.response(response, "注册失败,请重新注册");
			}
		}catch(Exception e){
			ResponseUtil.response(response, "注册失败,请重新注册");
			e.printStackTrace();
		}

     %>
  </body>
</html>
