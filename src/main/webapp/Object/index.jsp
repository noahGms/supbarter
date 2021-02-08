<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 08/02/2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Object list</title>
</head>
<body>
<h1>Object list</h1>
<c:out value="${error}"></c:out>
<c:out value="${sessionScope.updateObjectError}"></c:out>

<a href="add-objects">Add</a>

<c:forEach items="${objects}" var="object" >
    <p>${object.id}</p>
    <p>${object.title}</p>
    <p>${object.description}</p>
    <p>${object.price} €</p>
    <img src="${object.picture}" alt="object picture">
    <p>${object.type.name}</p>
    <p>${object.user.username}</p>
    <a href="show-objects/${object.id}">Show</a>
    <a href="update-objects/${object.id}">Update</a>
    <form action="delete-objects" method="post">
        <input type="hidden" name="id" value="${object.id}">
        <button type="submit">Delete</button>
    </form>
    <hr>
</c:forEach>
</body>
</html>
