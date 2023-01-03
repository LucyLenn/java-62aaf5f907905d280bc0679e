<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>

<html>
<head>
    <title>Orders page</title>
</head>
<body>
<h2>List of Orders</h2>
<table>
    <tr>
        <td>ID</td>
        <td>DATE</td>
        <td>COST</td>
    </tr>
    <c:forEach items="${orderRepository}" var="order">
        <tr>
            <td><a href="order-${order.id}">${order.id}</a></td>
            <td>${order.date}</td>
            <td>${order.cost/100}</td>
        </tr>
    </c:forEach>

</table>
To get info by order click to id.
<br>
<a href="/">return to main</a>
</body>
</html>