<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.dao.*" %>
<%@ page import="com.star.domain.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookAdd-b.jsp' starting page</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		div{text-align:center;margin:10px;}
	</style>
  </head>
  
  <body>
  <%
  		BookDao bookDao = new BookDao();
    	
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String author = request.getParameter("author");

		User user = (User)session.getAttribute("user");
		int manager = user.getManager();

		int flag = bookDao.add(name, author);
		String message = "";
		if(flag != 0){
			message = "添加成功";
		}else{
			message = "添加失败";
		}
   %>
  <div><h3><%= message%></h3><a href = <%= manager == 1 ? "showBook.jsp" : "showBookCommon.jsp"%> >返回</a><div/>
  </body>
</html>
