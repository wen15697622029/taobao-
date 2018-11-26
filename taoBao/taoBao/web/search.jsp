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
    <link rel="stylesheet" href="css/user.css" type="text/css"/>
    <script src="js/jquery.js"></script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="myUserDetail">&emsp;${sessionScope.user.name}</a>
        </div>
        <div id="d12">
            <a href="user" style="color: red">淘宝网首页&emsp;</a>
            <a href="myOrders" >我的淘宝&emsp;</a>
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
            <table >
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="150px">类型</th>
                    <th width="170px">描述</th>
                    <th width="150px">厂商</th>
                    <th width="50px">库存</th>
                    <th width="50px">数量</th>
                    <th width="50px">价格</th>
                    <th width="60px">购物车</th>
                    <th width="50px">下单</th>
                </tr>
<c:forEach items="${sessionScope.goods}" var="good" varStatus="loop">
                <tr >
                    <form action="addOrders" method="post">
                    <td>${good.id}</td>
                    <td>${good.name}</td>
                    <td>${good.price}</td>
                    <td>${good.type}</td>
                    <td>${good.description}</td>
                    <td>${good.factory}</td>
                    <td>${good.stock.gcount}</td>
                    <td><input style="width: 50px" class="number" name="gcount" type="number" value="1" min="1" max="${good.stock.gcount}"></td>
                    <td>${good.price}</td>
                    <td><input type="button" value="加入"></td>
                    <td>
                        <input type="hidden" name="gid" value="${good.id}" />
                        <input type="submit"  value="下单" />
                    </td>
                    </form>
                </tr>
</c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="search?name=${sessionScope.name}&currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
            <a href="search?name=${sessionScope.name}&currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
            共${sessionScope.totalPages}页
            <a href="search?name=${sessionScope.name}&currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
            <form action="search" method="post">
                <input type="hidden" name="name" value="${sessionScope.name}">
                <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("input[class=number]").change(function () {
            var a=parseFloat($(this).parent().siblings().eq(3).text());
            var b = parseInt($(this).val());
            $(this).parent().siblings().eq(8).text(parseFloat(a*b));
        })
        $("input[type=button]").click(function () {
            var gid = $(this).parent().siblings().eq(1).text();
            var gcount = $(this).parent().siblings().eq(8).children().val();
            $.ajax({
                type:"post",
                url:"addBuyCar",
                data:{gid:gid,gcount:gcount},
                success:function (obj) {//成功后回调函数

                },
                error:function (obj) {
                }
            })
        })
    })
</script>
</body>
</html>
