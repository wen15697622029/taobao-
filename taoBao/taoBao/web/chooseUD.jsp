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
    <title>选择收货地址</title>
    <link rel="stylesheet" href="css/user.css" type="text/css"/>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="myUserDetail">&emsp;${sessionScope.user.name}</a>
        </div>
        <div id="d12">
            <a href="user">淘宝网首页&emsp;</a>
            <a href="myOrders">我的淘宝&emsp;</a>
            <a href="buyCar">购物车&emsp;</a>
        </div>
    </div>
    <div id="d2">
        <div id="d21"><img src="ressources/images/1.jpg"></div>
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
        <div id="d31">
            <table>
                <tr style="background-color: #faebd7">
                    <th width="20px">ID</th>
                    <th width="120px">收货人</th>
                    <th width="80px">电话</th>
                    <th width="100px">收货地址</th>
                    <th width="100px">提交</th>
                </tr>
<c:forEach items="${sessionScope.userDetails}" var="userDetail">
                <tr >
                    <form action="xdOrders" method="post">
                    <td>${userDetail.id}</td>
                    <td>${userDetail.receiver}</td>
                    <td>${userDetail.phone}</td>
                    <td>${userDetail.address}</td>
                    <td>
                        <input type="hidden" name="udid" value="${userDetail.id}"/>
                        <input type="submit"  value="选择"/></td>
                    </form>
                </tr>
</c:forEach>
            </table>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>
