<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="CSS/LR.css">
</head>
<body>
<div class="box">

    <div class="top">
        <h2>登陆</h2>
    </div>

    <div class="Z">
        <form action="<%=request.getContextPath()%>/user/login" method="post">
            <div class="i1">
                <div>账号：<input type="text" name="account"></div>
            </div>
            <div class="i2">
                <div>密码：<input type="password" name="password"></div>
            </div>
            <div class="D">
                <input type="submit" value="完成" class="ibutton">
                <div class="ck"><input type="checkbox" name="flag" value="1">十天内免登录</div>
            </div>

        </form>
    </div>

</div>
</body>
</html>
