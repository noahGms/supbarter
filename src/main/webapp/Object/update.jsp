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
    <title>Update Object</title>
</head>
<body>
<h1>Update object ${object.id}</h1>
<c:out value="${error}"></c:out>
<form action="" method="post">
    <input type="hidden" name="id" value="${object.id}">
    <div>
        <label for="title">Title</label>
        <input type="text" name="title" placeholder="title" value="${object.title}">
    </div>
    <div>
        <label for="description">Description</label>
        <textarea name="description" cols="30" rows="10" placeholder="Description">${object.description}</textarea>
    </div>
    <div>
        <label for="price">Price</label>
        <input type="number" min="0.01" step="0.01" name="price" value="${object.price}" />
    </div>
    <div>
        <label for="picture">Picture link</label>
        <input type="text" name="picture" placeholder="Picture link" value="${object.picture}">
    </div>
    <div>
        <label for="type">type</label>
        <select name="type">
            <option value="">--Please choose an option--</option>
            <c:forEach items="${objectTypes}" var="type" >
                <option <c:if test="${type.id == requestScope.object.type.id}"> selected </c:if> value="${type.id}">${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
