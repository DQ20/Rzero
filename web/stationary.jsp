<%@ page import="com.Husky.superMarket.pojo.CartGoods" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>商品</title>
  <link rel="stylesheet" href="../CSS/showData.css">
</head>
<body>
<div class="left">
  <ul>
    <li><a href="<%=request.getContextPath()%>/fruit/all?id=user&kind=fruit"><img src="../images/fruits.png"></a><span>水果</span></li>
    <li><a href="<%=request.getContextPath()%>/stationary/all?id=user&kind=stationary"><img src="../images/stationary.png"></a><span>文具</span></li>
    <li><a href="<%=request.getContextPath()%>/user/exit"><img src="../images/exit.png"></a></li>
  </ul>
</div>

<div class="con">
  <div class="conTop">
    <form action="<%=request.getContextPath()%>/stationary/search?id=user&kind=stationary" method="post">
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
        <th>产地</th>
        <th>购买</th>
      </tr>
      <c:forEach items="${stationaryList}" var="S">
        <c:if test="${S.getNum()!=null&&S.getNum()>0}">
          <tr>
            <td>${S.getName()}</td>
            <td>${S.getPrice()}/${S.getUnit()}</td>
            <td>${S.getProductPlace()}</td>
            <td><a href="<%=request.getContextPath()%>/cart/add?name=${S.getName()}&kind=stationary&id=user"><img src="../images/add.png"></a></td>
          </tr>
        </c:if>
      </c:forEach>
    </table>
  </div>
</div>

<div class="right">
  <div class="Rtop"><img src="../images/trolley.png" alt=""></div>
  <div class="Rcon">
    <table class="TB">
      <tr class="head">
        <td>名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>去除</td>
      </tr>
      <c:forEach items="${cartList}" var="C">
        <c:if test="${C.getNum()!=null&&C.getNum()>0}">
          <tr>
            <td>${C.getName()}</td>
            <td>${C.getPrice()}</td>
            <td>${C.getNum()}</td>
            <td><a href="<%=request.getContextPath()%>/cart/delete?name=${C.getName()}&kind=stationary&id=user&kind=statioanary"><img src="../images/jian.png"></a></td>
          </tr>
        </c:if>
      </c:forEach>
      <div class="clear"><a href="<%=request.getContextPath()%>/cart/clear?Fi=clear" class="bl">清空购物车</a></div>
    </table>
  </div>
  <div class="Rsum">
    <span>总价:</span>
    <div>
      <%
        double num=0;
        List<CartGoods> list=(List<CartGoods>) request.getAttribute("cartList");
        for (CartGoods g:
            list) {
          num=num+g.getPrice()*g.getNum();
        }
        out.print(num);
      %>
    </div>
  </div>
  <div class="Rbut">
    <a class="bt" href="<%=request.getContextPath()%>/cart/clear?Fi=buy">购买</a>
  </div>
</div>
</body>
</html>
