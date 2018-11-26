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
        <a href="sfhOrders" style="color: red">所有记录</a>
        <a href="shAdmin.jsp">收货</a>
        <a href="fhAdmin">发货</a>
    </div>
    <div id="d3">
        <div id="d31">
            <table>
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="80px">商品ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="50px">数量</th>
                    <th width="80px">金额</th>
                    <th width="220px">时间</th>
                    <th width="80px">状态</th>
                </tr>
<c:forEach items="${sessionScope.stockRecordList}" var="stockRecord" varStatus="loop">
                <tr >
                    <td>${stockRecord.id}</td>
                    <td>${stockRecord.good.id}</td>
                    <td>${stockRecord.good.name}</td>
                    <td>${stockRecord.good.price}</td>
                    <td>${stockRecord.gcount}</td>
                    <td>${(stockRecord.gcount)*(stockRecord.good.price)}</td>
                    <td>${stockRecord.time}</td>
                    <td>${stockRecord.state==1?"入库":"出库"}</td>
                </tr>
</c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="sfhOrders?currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
            <a href="sfhOrders?currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
            共${sessionScope.totalPages}页
            <a href="sfhOrders?currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
            <form action="sfhOrders" method="post">
                <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
