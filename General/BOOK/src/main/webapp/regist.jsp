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
        p{color:red;}
	</style>
  </head>
  
  <body>
    <div>
    <form action="#" method="post" >
    	username:<input type="text" name="username" id="username"/><br/>
    	password:<input type="password" name="password" id="password"/><br/>
    	<select name="manager" id="manager">
    		<option value="0">普通用户</option>
    		<option value="1">管理员</option>
    	</select>
    	<br/>
    	<input type="button" value="regist" onclick="show()"/>
        <p></p>
    </form>

    </div>

  <script>
      var p = document.getElementsByTagName("p")[0];
      var xmlHttp;
      if(window.XMLHttpRequest){
          xmlHttp = new XMLHttpRequest;
      }else{
          xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
      }
      function show(){
          var username = document.getElementById("username").value;
          var password = document.getElementById("password").value;
          var manager = document.getElementById("manager").value;
          var formData = "username=" + username + "&password=" + password + "&manager=" + manager;
          xmlHttp.open("POST","regist-b.jsp", true);
          xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
          xmlHttp.send(formData);
          xmlHttp.onreadystatechange = function(){
              if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
                  var success = xmlHttp.responseText
                  if(success === "1"){
                      alert("注册成功，请登录")
                      window.location = "login.jsp";
                  }else{
                      p.innerHTML = xmlHttp.responseText;
                  }
              }
          }
      }
  </script>

  </body>
</html>
