<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 06/02/2021
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<h1>List of users</h1>
<c:out value="hello world"></c:out>
<c:forEach var="i" begin="0" end="10" step="2">
    <p>Un message n°<c:out value="${ i }" /> !</p>
</c:forEach>
<c:forEach items="${users}" var="user" >
    <p>${user.email}</p>
    <p>${user.password}</p>
    <c:out value="${user.firstname}"></c:out>
    <p>${user.firstname}</p>
    <p>${user.lastname}</p>
    <p>${user.zipcode}</p>
</c:forEach>
</body>
</html>
