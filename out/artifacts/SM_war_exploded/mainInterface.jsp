<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品</title>
    <link rel="stylesheet" href="CSS/mainInterface.css">
</head>
<body>
<div class="left">
    <ul>
        <li><a href="<%=request.getContextPath()%>/fruit/all?id=user"><img src="./images/fruits.png"></a><span>水果</span></li>
        <li><a href="<%=request.getContextPath()%>/stationary/all?id=user"><img src="./images/stationary.png"></a><span>文具</span></li>
        <li><a href="<%=request.getContextPath()%>/user/exit"><img src="./images/exit.png"></a></li>
    </ul>
</div>

<div class="con">
    <div class="conTop clearfix">商品</div>
    <hr>

</div>

<div class="right">
    <div class="Rtop"><img src="../images/trolley.png" alt=""></div>
    <div class="Rcon"></div>
    <div class="Rsum">
        <span></span>
        <div></div>
    </div>
<%--    <div class="Rbut">--%>
<%--        <input type="submit" value="购买">--%>
<%--    </div>--%>
</div>
</body>
</html>