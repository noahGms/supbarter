<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 07/02/2021
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h1>Update my user</h1>
<c:out value="${error}"></c:out>
<form action="update-user" method="post">
    <div>
        <label for="email">Email</label>
        <input type="text" name="email" value="${sessionScope.currentUser.email}" placeholder="Email address">
    </div>
    <div>
        <label for="firstname">Firstname</label>
        <input type="text" name="firstname" value="${sessionScope.currentUser.firstname}" placeholder="Firstname">
    </div>
    <div>
        <label for="lastname">Lastname</label>
        <input type="text" name="lastname" value="${sessionScope.currentUser.lastname}" placeholder="Lastname">
    </div>
    <div>
        <label for="zipcode">ZipCode</label>
        <input type="text" name="zipcode" value="${sessionScope.currentUser.zipcode}" placeholder="ZipCode">
    </div>

    <div>
        <label for="currentPassword">Current password</label>
        <input type="text" name="currentPassword" placeholder="Current password">
    </div>
    <div>
        <label for="newPassword">New password</label>
        <input type="text" name="newPassword" placeholder="New password">
    </div>
    <div>
        <label for="newPasswordConfirmation">New password confirmation</label>
        <input type="text" name="newPasswordConfirmation" placeholder="New password confirmation">
    </div>

    <button type="submit">Update</button>
</form>
</body>
</html>
