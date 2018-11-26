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
    <link rel="stylesheet" href="css/myOrders.css" type="text/css"/>
    <script>
        function dd(i) {
            var id1 = "div"+i;
            x = document.getElementById(id1);
            if(x.style.display=="none"){
                x.style.display="block";
            }else{
                x.style.display="none";
            }
        }
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="myUserDetail">&emsp;${sessionScope.user.name}</a>
        </div>
        <div id="d12">
            <a href="user">淘宝网首页&emsp;</a>
            <a href="myOrders" style="color: red">我的淘宝&emsp;</a>
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
    <div id="d4">
        <a href="myOrders">所有订单</a>
        <a href="dfkOrders">待付款</a>
        <a href="dfhOrders">待发货</a>
        <a href="dshOrders">待收货</a>
        <a href="dpjOrders">待评价</a>
        <a href="tkzOrders" style="color: red">退款中</a>
    </div>
    <div id="d3">
        <div id="d31">
            <table>
                <tr style="background-color: #faebd7">
                    <th width="40px">ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="50px">数量</th>
                    <th width="220px">时间</th>
                    <th width="80px">价格</th>
                    <th width="80px">付款</th>
                    <th width="80px">发货</th>
                    <th width="60px">详情</th>
                    <th width="60px">撤销</th>
                </tr>
<c:forEach items="${sessionScope.orders}" var="order" varStatus="loop">
                <tr >
                    <td>${order.id}</td>
                    <td>${order.good.name}</td>
                    <td>${order.good.price}</td>
                    <td>${order.gcount}</td>
                    <td>${order.time}</td>
                    <td>${order.money}</td>
                    <td>${order.state==0?"未付款":order.state==1?"已付款":order.state==2?"退款中":"已退款"}</td>
                    <td>${order.delivery==0?"未发货":order.delivery==1?"已发货":order.delivery==2?"已确认":"已评价"}</td>
                    <td><input type="button" value="详情" onclick="dd(${loop.count-1})"></td>
                    <form method="post" action="cxOrders">
                    <td>
                        <input name="ordersId" type="hidden" value="${order.id}">
                        <input type="submit" value="撤销"></td>
                    </form>
                </tr>
    <div id="div${loop.count-1}" style="display:none;position:absolute;left: 10px;text-align: left">
        订单号：${order.id}<br/>商品名：${order.good.name}<br/>
        单价：${order.good.price}<br/>类型：${order.good.type}<br/>
        厂商：${order.good.factory}<br/>数量：${order.gcount}<br/>
        时间：${order.time}<br/>金额：${order.money}<br/>
        付款状态：${order.state==0?"未付款":order.state==1?"已付款":order.state==2?"退款中":"已退款"}<br/>
        发货状态：${order.delivery==0?"未发货":order.delivery==1?"已发货":order.delivery==2?"已确认":"已评价"}<br/>
        收货人：${order.userDetail.receiver}<br/>
        电话：${order.userDetail.phone}<br/>
        地址：${order.userDetail.address}
    </div>
</c:forEach>
            </table>
        </div>
        <div id="d32" >
            <a href="tkzOrders?currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
            <a href="tkzOrders?currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
            共${sessionScope.totalPages}页
            <a href="tkzOrders?currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
            <form action="tkzOrders" method="post">
                <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
</body>
</html>
