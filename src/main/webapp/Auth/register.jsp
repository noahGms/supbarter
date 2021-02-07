<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 06/02/2021
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register perso</h1>
<c:out value="${error}"></c:out>
<form action="register" method="post">
    <div>
        <label for="email">Email</label>
        <input type="text" name="email" placeholder="Email address">
    </div>
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" placeholder="Username">
    </div>
    <div>
        <label for="firstname">Firstname</label>
        <input type="text" name="firstname" placeholder="Firstname">
    </div>
    <div>
        <label for="lastname">Lastname</label>
        <input type="text" name="lastname" placeholder="Lastname">
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" placeholder="Password">
    </div>
    <div>
        <label for="passwordConfirmation">Password confirmation</label>
        <input type="password" name="passwordConfirmation" placeholder="Password confirmation">
    </div>
    <div>
        <label for="zipCode">ZipCode</label>
        <input type="text" name="zipCode" placeholder="ZipCode" inputmode="number" pattern="^(?(^00000(|-0000))|(\d{5}(|-\d{4})))$">
    </div>

    <button type="submit">Register</button>
</form>
</body>
</html>
