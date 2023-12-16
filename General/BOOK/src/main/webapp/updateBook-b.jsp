<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.dao.*"  %>
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
    	BookDao bookDao = new BookDao();
    	request.setCharacterEncoding("UTF-8");
    	String id = request.getParameter("id");
    	int iid = Integer.parseInt(id);
    	String name = request.getParameter("name");
    	String author = request.getParameter("author");
    	
    	int result = bookDao.update(iid, name, author);
    	if(result == 0){
    		response.getWriter().write("修改失败");
    	}else{
    		request.getRequestDispatcher("showBook.jsp").forward(request, response);
    	}
     %>
  </body>
</html>
