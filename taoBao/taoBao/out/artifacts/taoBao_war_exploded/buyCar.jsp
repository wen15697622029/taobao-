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
    <script src="js/jquery.js"></script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="myUserDetail">&emsp;${sessionScope.user.name}</a>
        </div>
        <div id="d12">
            <a href="user">淘宝网首页&emsp;</a>
            <a href="myOrders" >我的淘宝&emsp;</a>
            <a href="buyCar" style="color: red">购物车&emsp;</a>
        </div>
    </div>
    <div id="d2">
        <div id="d21"><img src="ressources/images/7.jpg"></div>
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
                    <th width="80px"><input type="checkbox" name="all" >全选</th>
                    <th width="40px">ID</th>
                    <th width="150px">商品</th>
                    <th width="80px">单价</th>
                    <th width="50px">数量</th>
                    <th width="80px">金额</th>
                    <th width="60px">删除</th>
                </tr>
<c:forEach items="${sessionScope.buyCars}" var="buyCar">
                <tr >
                    <td width="80px"><input type="checkbox" name="buyCarIds" value="${buyCar.id}"></td>
                    <td>${buyCar.id}</td>
                    <td>${buyCar.good.name}</td>
                    <td>${buyCar.good.price}</td>
                    <td><input style="width: 50px" type="number" min="1" max="${buyCar.good.stock.gcount}"  name="gcount" value="${buyCar.gcount}"></td>
                    <td>${buyCar.good.price*buyCar.gcount}</td>
                    <td>
                        <a href="deleteBuyCar?id=${buyCar.id}&buyCarPage=${sessionScope.buyCarPage}" class="">删除</a>
                    </td>
                </tr>
</c:forEach>
                <tr style="background-color: aliceblue">
                    <td colspan="2">总价</td>
                    <form action="buyCarXD" method="post">
                    <td ><input type="number" name="money1" readonly="readonly" step="0.01"  id="z1" value="" min="0"></td>
                    <td colspan="3">
                        <select name="udid">
<c:forEach items="${sessionScope.userDetails}" var="userDetail">

                            <option value="${userDetail.id}">收货人:${userDetail.receiver}电话:${userDetail.phone}地址:${userDetail.address}</option>
</c:forEach>
                        </select>
                        <input type="hidden" name="buyCarIDs" value="" id="z2"></td>
                    <td ><input type="submit" value="结算" id="inpu"></td>
                    </form>
                </tr>
            </table>
        </div>
        <div id="d32" >
            <a href="buyCar?currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
            <a href="buyCar?currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
            共${sessionScope.totalPages}页
            <a href="buyCar?currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
            <form action="buyCar" method="post">
                <input name="uid" type="hidden" value="${sessionScope.user.getId()}">
                <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
                <input type="submit" value="跳转">
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#inpu").click(function () {
            var id = new Array();
            var flag = false;
            $("input[name=buyCarIds]").each(function () {
                if($(this).is(':checked')){
                    flag = true;
                    id.push($(this).val());
                }
            })
            if(parseInt($("#z1").val())>${sessionScope.user.money}){
                alert("你的余额不足，请充值")
            }
            $("#z2").val(id);
            if(flag){
                return true;
            }
            return false;
        });
        $("input[name=gcount]").change(function () {
            var id = parseInt($(this).parent().siblings().eq(1).text());
            var gcount = $(this).val();
            var price = parseFloat($(this).parent().siblings().eq(3).text())
            $(this).parent().siblings().eq(4).text(price*gcount);
            tj();
            $.ajax({
                type:"post",
                url:"updateBuyCar",
                data:{id:id,gcount:gcount},
                success:function (obj) {//成功后回调函数

                },
                error:function (obj) {
                    $("#s1").html(obj);
                }
            })
        })
        $("input[type=checkbox]").change(function () {
            var flag = true;
            if($(this).is(':checked')){
                $("input[name=buyCarIds]").each(function () {
                    if(!$(this).is(':checked')){
                        flag=false;
                        return flag;
                    }
                })
                if (flag){
                    $("input[name=all]").attr("checked",'true');
                }
            }else{
                if($("input[name=all]").is(':checked')){
                    $("input[name=all]").removeAttr("checked");
                }
            }
            tj();
        })
        function tj() {
            var count = 0.0;
            $("input[name=buyCarIds]").each(function () {
                if($(this).is(':checked')){
                    count+=parseFloat($(this).parent().siblings().eq(4).text());
                }
            })
            $("#z1").val(count);
        }
        $("input[name=all]").change(function () {
            if($("input[name=all]").is(':checked')){
                $("input[name=buyCarIds]").each(function () {
                    $(this).attr("checked",'true');
                })
            }else{
                $("input[name=buyCarIds]").each(function () {
                    $(this).removeAttr("checked");
                })
            }
            tj();
        })
    })
</script>
</body>
</html>
