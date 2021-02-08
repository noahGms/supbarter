<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 08/02/2021
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Object Type</title>
</head>
<body>
<h1>Update object type ${objectType.id}</h1>
<form action="" method="post">
    <input type="hidden" name="id" value="${objectType.id}">
    <label for="name">Name</label>
    <input type="text" name="name" value="${objectType.name}" placeholder="name">
    <button type="submit">Update</button>
</form>
</body>
</html>
