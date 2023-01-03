<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>

<html>
<head>
    <title>Order page</title>
</head>
<body>
<h1>Order info</h1>
<c:if test="${order != null}">
    ID: ${order.id} <br>
    DATE: ${order.date} <br>
    COST: ${order.cost/100} <br>
    PRODUCT: <br>

    <c:forEach items="${order.products}" var="product">
        ${product.toString()} <br>
    </c:forEach>
</c:if>

<c:if test="${order == null}">
    <h5>Order does not exist. Check ID</h5>--%>
</c:if>

<a href="/orders">return to orders</a>
<a href="/">return to main</a>
</body>
</html>
