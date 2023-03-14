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
    <form action="<%=request.getContextPath()%>/fruit/modify?id=root&kind=fruit" method="post">
        <div class="one">
            <div>名称：<input type="text" name="name" required="required"></div>
            <div>价格：<input type="text" name="price" onkeyup="value=value.replace(/[^\d.]/g,'')" required="required"></div>
        </div>
        <div class="two">
            <div>生产日期：<input type="text" name="productionDate" required="required" placeholder="xxxx-xx-xx"></div>
            <div>保质期：<input type="text" name="PreservationPeriod" onkeyup="value=value.replace(/[^\d.]/g,'')" required="required"></div>
            <div>单位：<input type="text" name="Unit" required="required"></div>
            <div>数量：<input type="text" name="num" onkeyup="value=value.replace(/[^\d.]/g,'')" required="required"></div>

        </div>
        <input type="submit" value="完成" class="B">
    </form>
</div>
</body>
</html>

