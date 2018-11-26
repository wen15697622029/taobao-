<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="css/admin.css" type="text/css"/>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            &emsp;${sessionScope.admin.name}
        </div>
        <div id="d12">
            <a href="admin">商品管理&emsp;</a>
            <a href="sfhOrders" style="color: red">收发货管理&emsp;</a>
            <a href="tkAdmin">退款处理&emsp;</a>
        </div>
    </div>
    <div id="d2">
        <div id="d21"><img src="ressources/images/1.jpg"></div>
        <div id="d22">
            <span style="line-height: 100px">
            <form method="post" action="adminSearch">
                <input type="text" name="name" style="height: 40px;width: 300px;margin-left: 100px">
                <input type="submit" value="搜索" style="height: 40px">
            </form>
            </span>
        </div>
    </div>
    <div id="d4">
        <a href="sfhOrders">所有记录</a>
        <a href="shAdmin.jsp" style="color: red">收货</a>
        <a href="fhAdmin">发货</a>
    </div>
    <div id="d3" style="font-size: 24px;text-align: center">
        <form method="post" action="shAdmin">
            商品名:<input type="text" name="name"><br>
            价格：<input type="number" min="0.01" step="0.01" name="price"><br>
            类型：<input type="text" name="type"><br>
            描述：<input type="text" name="description"><br>
            厂商：<input type="text" name="factory"><br>
            数量：<input type="number" min="1" name="gcount"><br>
            <input type="submit" value="入库"/>
        </form>
    </div>
</div>
</body>
</html>
