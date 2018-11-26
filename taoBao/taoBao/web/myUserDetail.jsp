<%--
  Created by IntelliJ IDEA.
  User: destiny
  Date: 2018/6/26/0026
  Time: 9:47
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
    <link rel="stylesheet" href="css/myUserDetail.css" type="text/css"/>
    <script type="text/javascript" src="js/myUserDetail.js"></script>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            $("#form1").submit(function () {
                if($("#receiver1").val()==""||$("#phone1").val()==""||$("#address1").val()==""){
                    alert("不能为空");
                    return false;
                }
                return true;
            });
            $("#form2").submit(function () {
                if($("#receiver2").val()==""||$("#phone2").val()==""||$("#address2").val()==""){
                    alert("不能为空");
                    return false;
                }
                return true;
            });
        })
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
            <a href="myOrders" >我的淘宝&emsp;</a>
            <a href="buyCar">购物车&emsp;</a>
        </div>
    </div>
    <div id="d2" style="background-color: orangered">
        <div id="d21"><img src="ressources/images/8.jpg"></div>
        <div id="d22">
            <span style="line-height: 80px">
            <form method="post" action="search">
                <input type="text" name="name" style="height: 40px;width: 300px;margin-left: 100px">
                <input type="submit" value="搜索" style="height: 40px">
            </form>
            </span>
        </div>
    </div>
    <div id="d3" style="font-size: 20px;background-color: rgba(0, 0, 0, 0.06)">
        <div id="d31">
            <div id="d311" >
                <legend style="font-size: 20px" >添加收货地址</legend>
                <form action="addUserDetail" id="form1" method="post">
                    收货人:<input type="text" name="receiver" id="receiver1" style="width: 100px">
                    电  话:<input type="text" name="phone" id="phone1" style="width: 100px">
                    地  址:<input type="text" name="address" id="address1" style="width: 200px">
                    <input type="submit" value="添加">
                </form>
                </fieldset>
            </div>
            <div id="d312">
                <fieldset style="text-align: center">
                    <legend style="font-size: 22px;text-align: center">收货地址</legend>
                    <table>
                        <tr>
                            <th width="30px">ID</th>
                            <th>收件人</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>用户</th>
                            <th>修改</th>
                            <th>删除</th>
                        </tr>
<c:forEach items="${sessionScope.userDetailList}" var="userDetail" varStatus="loop">
                        <tr >
                            <form  action="alterUserDetail" method="post" id="form2">
                                <td><input value="${userDetail.id}" disabled="true" style="width: 30px"></td>
                                <td><input name="receiver" id="receiver2" value="${userDetail.receiver}"></td>
                                <td><input name="phone" id="phone2" value="${userDetail.phone}"></td>
                                <td><input name="address" id="address2" value="${userDetail.address}"></td>
                                <td><input value="${userDetail.user.name}" disabled="true" style="width: 50px"></td>
                                <td><input name="id" type="hidden" value="${userDetail.id}">
                                    <input type="submit" value="修改"></td>
                            </form>
                            <form action="delUserDetail" method="post">
                                <td>
                                    <input name="id" type="hidden" value="${userDetail.id}">
                                    <input type="submit" value="删除">
                                </td>
                            </form>
                        </tr>
</c:forEach>
                        <tr>
                            <td colspan="7">
                                ${error2}
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <a href="myUserDetail?currentPage=${sessionScope.currentPage-1==0?sessionScope.currentPage:sessionScope.currentPage-1}">上一页</a>
                <a href="myUserDetail?currentPage=${sessionScope.currentPage}">第${sessionScope.currentPage}页</a>
                共${sessionScope.totalPages}页
                <a href="myUserDetail?currentPage=${sessionScope.currentPage+1>sessionScope.totalPages?sessionScope.currentPage:sessionScope.currentPage+1}">下一页</a>
                <form action="myUserDetail" method="post">
                    <input style="width: 30px" type="number" min="1" max="${sessionScope.totalPages}" value="${sessionScope.currentPage}" name="currentPage">
                    <input type="submit" value="跳转">
                </form>
            </div>
            </div>
        </div>
        <div id="d32">
            <div id="d321">
                <fieldset style="text-align: center">
                    <legend style="font-size: 22px;text-align: center">个人信息</legend>
                    <p>用户ID:${sessionScope.user.id}</p>
                    <p>用户名:${sessionScope.user.name}</p>
                    <p>性  别:${sessionScope.user.sex}</p>
                    <p>余  额:${sessionScope.user.money}</p>
                    <form method="post" action="chongZhi">
                        <input type="hidden" value="${sessionScope.user.id}" name="uid">
                        <input type="number" min="0" max="20000" value="0" name="money">
                        <input type="submit" value="充值">
                    </form>
                </fieldset>
            </div>
            <div id="d322"><fieldset style="text-align: left">
                <legend style="font-size: 22px;text-align: center">修改密码</legend>
                <form action="changePassword" method="post">
                    原密码:<input onfocus="checkPwd('pass1')" onblur="chenckPwd1('pwd1','pass1')" type="password" name="oldpassword" id="pwd1"><span id="pass1" style="color: red;font-size: 18px"></span><br/>
                    新密码:<input onfocus="checkPwd('pass')" onblur="chenckPwd2('pwd','pass')" type="password" name="newpassword" id="pwd"><span id="pass" style="color: red;font-size: 18px"></span><br/>
                    <input type="submit" value="修改" disabled="true" id="change">${error}
                </form>
            </fieldset></div>
        </div>
    </div>
</div>
</body>
</html>
