<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 07/02/2021
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add object type</h1>
<form action="add-object-types" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" placeholder="name">
    <button type="submit">Add</button>
</form>
</body>
</html>
