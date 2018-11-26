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
            <a href="admin" style="color: red">商品管理&emsp;</a>
            <a href="sfhOrders" >收发货管理&emsp;</a>
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
        <a href="admin">所有商品</a>
        <a href="sjAdmin">上架</a>
        <a href="xjAdmin" style="color: red">下架</a>
    </div>
    <div id="d3">
        <div id="d31">
            <table>
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="150px">类型</th>
                    <th width="150px">描述</th>
                    <th width="150px">厂商</th>
                    <th width="100px">虚拟库存</th>
                    <th width="100px">实际库存</th>
                    <th width="60px">下架</th>
                </tr>
<c:forEach items="${sessionScope.goods}" var="good" varStatus="loop">
                <tr >
                    <td>${good.id}</td>
                    <td>${good.name}</td>
                    <td>${good.price}</td>
                    <td>${good.type}</td>
                    <td>${good.description}</td>
                    <td>${good.factory}</td>
                    <td>${good.stock.gcount}</td>
                    <td>${good.realStock.gcount}</td>
                    <form action="xjGood" method="post">
                        <td>
                            <input type="hidden" name="gid" value="${good.id}">
                            <input type="submit" value="下架">
                        </td>
                    </form>
                </tr>
</c:forEach>
            </table>
        </div>
    <div id="d32" >
        <a href="xjAdmin?currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
        <a href="xjAdmin?currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
        共${sessionScope.totalPages}页
        <a href="xjAdmin?currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
        <form action="xjAdmin" method="post">
        <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
        <input type="submit" value="跳转">
        </form>
        <span id="s1"></span>
    </div>
    </div>
</div>
</body>
</html>
