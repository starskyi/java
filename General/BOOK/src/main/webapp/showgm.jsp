<%@ page import="com.star.dao.ShopDao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 天泽
  Date: 2024/3/12
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String username = (String)session.getAttribute("username");
    ShopDao shopDao = new ShopDao();
    ResultSet resultSet = shopDao.queryByName(username);
    String productName;
    while(resultSet.next()){
        productName = resultSet.getString(1);
%>
<tr>
    <td><%= productName%></td>
</tr>
<%
    }
%>
</body>
</html>
