<%@ page import="com.star.dao.ShopDao" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 天泽
  Date: 2024/3/12
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ShopDao shopDao = new ShopDao();
    ResultSet resultSet = shopDao.query();
    String productName;
    String shipper;
    String statu;
    String selectBy;
    while(resultSet.next()){
        productName = resultSet.getString(1);
        shipper = resultSet.getString(2);
        statu = resultSet.getString(3);
        selectBy = resultSet.getString(4);
%>
<tr>
    <td><%= productName%></td>
    <td><%= shipper%></td>
    <td><a href="gm.jsp?productName=<%= statu.equals("1") ? productName : null%>"><%= statu.equals("1") ? "点击购买" : "不可购买"%></a></td>
    <td><%= selectBy%></td>
</tr>
<%
    }
%>
</body>
</html>
