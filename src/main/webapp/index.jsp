<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<c:if test="${sessionScope.isLogin}">
    <c:out value="${sessionScope.currentUser.email}"></c:out>
</c:if>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="register">Register servlet</a>
<a href="login">Login servlet</a>
<a href="users">User servlet</a>
<a href="object-types">Object types servlet</a>
<a href="objects">Object servlet</a>
<c:if test="${sessionScope.isLogin}">
    <a href="update-user">Update my user</a>
    <form action="logout" method="post">
        <button type="submit">Logout</button>
    </form>
</c:if>
</body>
</html>