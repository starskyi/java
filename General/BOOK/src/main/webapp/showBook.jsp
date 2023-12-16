<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.star.dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showBook.jsp' starting page</title>
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
    	while(resultSet.next()){
    		id = resultSet.getString(1);
    		name = resultSet.getString(2);
    		author = resultSet.getString(3);
    	//System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
    %>
    		<tr>
    			<td><%= (id == null ? "":id)%></td>
	    		<td><%= (name == null ? "":name)%></td>
	    		<td><%= (author == null ? "" : author)%></td>
				<td><a href="updateBook.jsp?id=<%=(id == null ? "":id)%>">修改</a></td>
				<td><a href="deleteBook.jsp?id=<%=(id == null ? "":id)%>">删除</a></td>
    		</tr>
    <%
    	}
    %>
    </table>
    <a href="home.jsp">首页</a>
  </div>

  </body>
</html>
