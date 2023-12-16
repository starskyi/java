<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <div>
    <a href="login.jsp">登录</a>
    <a href="regist.jsp">注册</a>
   </div>
  </body>
  
</html>
