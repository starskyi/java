<%@ page import="com.star.dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: 天泽
  Date: 2024/3/12
  Time: 12:42
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
    String productName = request.getParameter("productName");
    int result = shopDao.update(productName);

    if(result == 0){
        response.getWriter().write("修改失败");
    }else{
        request.getRequestDispatcher("showShop.jsp").forward(request, response);
    }
%>
</body>
</html>
