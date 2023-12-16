<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.dao.*" %>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	  <style>
		  *{margin:10px;}
		  div{text-align: center;}
	  </style>
  </head>
  
  <body>
    <%
    	BookDao bookDao = new BookDao();
    	String id = request.getParameter("id");
    	System.out.println(id);
    	int iid = Integer.parseInt(id);
    	
    	ResultSet resultSet = bookDao.findById(iid);
    	String name = null;
    	String author = null;
		try{
    		resultSet.next();
			name = resultSet.getString(2);
			author = resultSet.getString(3);
		}catch (Exception e){
			e.printStackTrace();
		}
     %>
     <div>
     <form action="updateBook-b.jsp" method="post" >
     	<input type="hidden" value="<%= (id == null ? "" : id) %>" name="id"/><br/>
     	name:<input type="text" name="name" value="<%= (name == null ? "" : name)%>"/><br/>
     	author:<input type="text" name="author" value="<%= (author == null ? "" : author)%>"/><br/>
     	<input type="submit" value="ok"/>
     </form>
	 </div>
  </body>
</html>
