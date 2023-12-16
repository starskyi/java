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
    
    <title>My JSP 'showBookCommon.jsp' starting page</title>
	  <style>
		  *{margin:10px;}
		  div{text-align: center;}
		  table{margin:0 auto}
	  </style>
  </head>
  
  <body>
  	<div>
		 <table style="border:1px solid;">
			<%
				BookDao bookDao = new BookDao();
				ResultSet resultSet = bookDao.query();
				String id;
				String name;
				String author;
				try{
					while(resultSet.next()){
						id = resultSet.getString(1);
						name = resultSet.getString(2);
						author = resultSet.getString(3);
			%>
						<tr>
							<td><%= (id == null ? "":id)%></td>
							<td><%= (name == null ? "":name)%></td>
							<td><%= (author == null ? "" : author)%></td>
						</tr>
			<%
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			%>
		</table>
    	<a href="home.jsp">首页</a>
	</div>

  </body>
</html>
