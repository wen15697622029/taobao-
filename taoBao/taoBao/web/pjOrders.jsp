<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/24/0024
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="css/user.css" type="text/css"/>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="myUserDetail?uid=${sessionScope.user.id}">&emsp;${sessionScope.user.name}</a>
        </div>
        <div id="d12">
            <a href="user">淘宝网首页&emsp;</a>
            <a href="myOrders" >我的淘宝&emsp;</a>
            <a href="buyCar">购物车&emsp;</a>
        </div>
    </div>
    <div id="d2">
        <div id="d21"><img src="ressources/images/9.jpg"></div>
        <div id="d22">
            <span style="line-height: 100px">
            <form method="post" action="search">
                <input type="text" name="name" style="height: 40px;width: 300px;margin-left: 100px">
                <input type="submit" value="搜索" style="height: 40px">
            </form>
            </span>
        </div>
    </div>

    <div id="d3">
        <form method="post" action="pj">
            <textarea name="comment" style="width:200px;height:80px;"></textarea>
            <input type="submit" value="评价">
        </form>
    </div>
</div>
</body>
</html>
