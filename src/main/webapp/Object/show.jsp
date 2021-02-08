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
    <title>show object</title>
</head>
<body>
<h1>Object n°${object.id}</h1>
<c:out value="${error}"></c:out>

<p>${object.id}</p>
<p>${object.title}</p>
<p>${object.description}</p>
<p>${object.price} €</p>
<img src="${object.picture}" alt="object picture">
<p>${object.type.name}</p>
<p>${object.user.username}</p>
<a href="${contextPath}/update-objects/${object.id}">Update</a>
<form action="${contextPath}/delete-objects" method="post">
    <input type="hidden" name="id" value="${object.id}">
    <button type="submit">Delete</button>
</form>
<hr>
</body>
</html>
