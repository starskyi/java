<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
    	
    <% 
    	String id = request.getParameter("id");
    	int iid = Integer.parseInt(id);
    	BookDao bookDao = new BookDao();
    	
    	int result = bookDao.delete(iid);
    	
    	request.getRequestDispatcher("showBook.jsp").forward(request, response);
    %>

  </body>
</html>
