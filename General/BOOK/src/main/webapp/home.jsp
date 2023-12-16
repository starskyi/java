<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.star.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
   
	<style>
    	*{margin:10px;}
 		div{text-align: center;}
	</style>
  </head>
  
  <body>
  <div>
  	<%
  		User user = (User)session.getAttribute("user");
  		if(user == null){
  			return;
  		}
  		if(user.getManager() == 1){
  	%>
  			<a href="showBook.jsp">显示</a>
  	<%		
  		}else{
  	%>
  			<a href="showBookCommon.jsp">显示</a>
    		
  	<%		
  		}
  	 %>
  			<a href="bookAdd.jsp">添加</a>
    </div>
  </body>
</html>
