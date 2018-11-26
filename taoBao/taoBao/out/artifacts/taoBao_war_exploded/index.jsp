<%@ page import="com.w.model.Good" %>
<%@ page import="java.util.List" %><%--
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
    <link rel="stylesheet" href="css/index.css" type="text/css"/>
    <script type="text/javascript" src="js/index.js"></script>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            $(".a1").click(function(){
                alert("使用前请登录");
            });
        })
    </script>
</head>
<body>
<div id="d">
    <div id="d1">
        <div id="d11">
            <a href="login.jsp">&emsp;亲，请登录</a>
            <a href="register.jsp">&emsp;免费注册</a>
        </div>
        <div id="d12">
            <a href="index.jsp">淘宝网首页&emsp;</a>
            <a href="#" class="a1">我的淘宝&emsp;</a>
            <a href="#" class="a1">购物车&emsp;</a>
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
    <div id="d3" style="font-size: 24px">
        <div id="d31">
        <table id="t1" style="font-size: 24px" cellspacing="10px">
            <tr>
                <th width="20px">ID</th>
                <th width="120px">商品</th>
                <th width="80px">价格</th>
                <th width="100px">类型</th>
                <th width="100px">描述</th>
                <th width="120px">厂商</th>
                <th width="50px">库存</th>
                <th width="50px">数量</th>
                <th width="80px">购物车</th>
                <th width="50px">下单</th>
            </tr>
            <%--<%
                List<Good> goods2 = null;
                List<Integer> gcounts2 = null;
                if (session.getAttribute("goods2")!=null){
                    goods2 = (List<Good>) session.getAttribute("goods2");
                }
                if (session.getAttribute("gcounts2")!=null){
                    gcounts2 = (List<Integer>) session.getAttribute("gcounts2");
                }
                int currentPage2 = 1;
                if(session.getAttribute("currentPage2")!=null){
                    currentPage2 = (int) session.getAttribute("currentPage2");
                }
                int totalPages2 = 1;
                if(session.getAttribute("totalPages2")!=null){
                    totalPages2 = (int) session.getAttribute("totalPages2");
                }
                for (int i = 0; null!=goods2&&i < goods2.size(); i++) {
            %>
            <tr >
                <td><%=goods2.get(i).getId()%></td>
                <td><%=goods2.get(i).getName()%></td>
                <td><%=goods2.get(i).getPrice()%></td>
                <td><%=goods2.get(i).getType()%></td>
                <td><%=goods2.get(i).getDescription()%></td>
                <td><%=goods2.get(i).getFactory()%></td>
                <td><%=gcounts2.get(i)%></td>
                <td>
                    <input style="width: 50px" type="number" min="1" max="<%=gcounts2.get(i)%>" name="gcount2" value="1">
                </td>
                <td><button  class="a1">加入</button></td>
                <td><button  class="a1">下单</button></td>
            </tr>
            <%
                }
            %>
        </table>--%>
        </div>
        <div id="d32" >
            <%--<a href="index?currentPage2=<%=currentPage2-1==0?currentPage2:currentPage2-1%>">上一页</a>
            <a href="index?currentPage2=<%=currentPage2%>">第<%=currentPage2%>页</a>
            共<%=totalPages2%>页
            <a href="index?currentPage2=<%=currentPage2+1>totalPages2?currentPage2:currentPage2+1%>">下一页</a>
            <form action="index" method="post">
                <input style="width: 30px" type="number" min="1" max="<%=totalPages2%>" value="<%=currentPage2%>" name="currentPage2">
                <input type="submit" value="跳转">
            </form>--%>
        </div>
    </div>
</div>
</body>
</html>
