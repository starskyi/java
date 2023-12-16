<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
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
    	<input type="button" value="login" onclick="show()"/>
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
            var formData = "username=" + username + "&password=" + password;
            xmlHttp.open("POST","login-b.jsp", true);
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlHttp.send(formData);
            xmlHttp.onreadystatechange = function(){
                if(xmlHttp.readyState === 4 && xmlHttp.status === 200){
                    var success = xmlHttp.responseText;
                    if(success === "1"){
                        window.location = "home.jsp";
                    }else{
                        p.innerHTML = success;
                    }

                }
            }
        }

    </script>
  </body>
</html>
