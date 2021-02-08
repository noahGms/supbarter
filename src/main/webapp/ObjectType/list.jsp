<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 07/02/2021
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Object Types list</title>
</head>
<body>
<h1>Object Types list</h1>
<c:out value="${error}"></c:out>

<a href="add-object-types">Add</a>

<c:forEach items="${objectTypes}" var="type" >
    <p>${type.id}</p>
    <p>${type.name}</p>
    <a href="update-object-types/${type.id}">Update</a>
    <form action="delete-object-types" method="post">
        <input type="hidden" name="id" value="${type.id}">
        <button type="submit">delete</button>
    </form>
</c:forEach>
</body>
</html>
