<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改</title>
    <link rel="stylesheet" href="CSS/AM.css">
</head>
<body>
<div class="box">
    <form action="<%=request.getContextPath()%>/stationary/modify?id=root&kind=stationary" method="post">
        <div class="one">
            <div>名称：<input type="text" name="name" required="required"></div>
            <div>价格：<input type="text" name="price" required="required" onkeyup="value=value.replace(/[^\d.]/g,'')"></div>
        </div>
        <div class="two">
            <div>产地：<input type="text" name="ProductPlace" required="required"></div>
            <div>单位：<input type="text" name="Unit" required="required"></div>
            <div>数量：<input type="text" name="num" required="required" onkeyup="value=value.replace(/[^\d.]/g,'')"></div>

        </div>
        <input type="submit" value="完成" class="B">
    </form>
</div>
</body>
</html>