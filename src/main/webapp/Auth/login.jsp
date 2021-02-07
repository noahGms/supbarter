<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 07/02/2021
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
    <c:out value="${error}"></c:out>
<form action="login" method="post">
    <div>
        <label for="email">Email</label>
        <input type="text" name="email" placeholder="Email address">
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" placeholder="Password">
    </div>
    <button type="submit">Login</button>
</form>
</body>
</html>
