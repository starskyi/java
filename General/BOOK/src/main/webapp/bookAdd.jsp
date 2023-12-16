<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookAdd.jsp' starting page</title>
    
	<style>
 		*{margin:10px;}
 		div{text-align: center;}
 	</style>

  </head>
  
  <body>

  <div>
    <form action="bookAdd-b.jsp" method="post" >
    	name:<input type="text" name="name" /><br/>
    	author:<input type="text" name="author"/><br/>
    	<input type="submit" value="add" />
    </form>
  </div>

  </body>
</html>
