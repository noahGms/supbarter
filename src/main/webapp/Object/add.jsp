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
<h1>Add object</h1>
<c:out value="${error}"></c:out>
<form action="add-objects" method="post">
    <div>
        <label for="title">Title</label>
        <input type="text" name="title" placeholder="title">
    </div>
    <div>
        <label for="description">Description</label>
        <textarea name="description" cols="30" rows="10" placeholder="Description"></textarea>
    </div>
    <div>
        <label for="price">Price</label>
        <input type="number" min="0.01" step="0.01" name="price" />
    </div>
    <div>
        <label for="picture">Picture link</label>
        <input type="text" name="picture" placeholder="Picture link">
    </div>
    <div>
        <label for="type">type</label>
        <select name="type">
            <option value="">--Please choose an option--</option>
            <c:forEach items="${objectTypes}" var="type" >
                <option value="${type.id}">${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit">Add</button>
</form>
</body>
</html>
