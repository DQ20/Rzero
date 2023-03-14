<%@ page import="com.Husky.superMarket.pojo.CartGoods" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品</title>
    <link rel="stylesheet" href="../CSS/Admini.css">
</head>
<body>
<div class="left">
    <ul>
        <li><a href="<%=request.getContextPath()%>/fruit/all?id=root&kind=fruit"><img src="../images/fruits.png"></a><span>水果</span></li>
        <li><a href="<%=request.getContextPath()%>/stationary/all?id=root&kind=stationary"><img src="../images/stationary.png"></a><span>文具</span></li>
        <li><a href="<%=request.getContextPath()%>/fruitAdd.jsp"><img src="../images/new.png" ></a><span>新增商品</span></li>
        <li><a href="<%=request.getContextPath()%>/user/exit"><img src="../images/exit.png"></a></li>
    </ul>
</div>

<div class="con">
    <div class="conTop">
        <form action="<%=request.getContextPath()%>/fruit/search?id=root&kind=fruit" method="post">
            <input type="text" class="S" name="ipName">
            <input type="image" src="../images/FDglass.png" class="F">
        </form>
        <span class="shop">商品</span>
    </div>
    <hr>

    <div class="context">
        <table class="TB">
            <tr class="head">
                <th>名称</th>
                <th>价格</th>
                <th>生产日期</th>
                <th>保质期</th>
                <th>库存</th>
                <th>删除</th>
                <th>修改</th>
            </tr>
            <c:forEach items="${fruitList}" var="F">
                    <tr>
                        <td>${F.getName()}</td>
                        <td>${F.getPrice()}/${F.getUnit()}</td>
                        <td>${F.getProductionDate()}</td>
                        <td>${F.getPreservationPeriod()}</td>
                        <td>${F.getNum()}</td>
                        <td><a href="<%=request.getContextPath()%>/fruit/delete?name=${F.getName()}&kind=fruit&id=root"><img src="../images/del.png"></a></td>
                        <td><a href="<%=request.getContextPath()%>/fruitModify.jsp?name=${F.getName()}&kind=fruit&id=root"><img src="../images/mod.png"></a></td>
                    </tr>
            </c:forEach>
        </table>
    </div>
</div>


<div class="right">
    <div class="Rtop">用户列表</div>
    <div>
        <table class="TB">
            <tr>
                <th>用户名</th>
            </tr>
            <c:forEach items="${userList}" var="U">
                <tr>
                    <td>${U.getAccount()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
