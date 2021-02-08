<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | TYPES</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Types
        <c:if test="${sessionScope.isLogin}">
            <a href="add-object-types" class="btn btn-primary">Add</a>
        </c:if>
    </h1>

    <div class="mb-3 text-center">
        <span class="fs-3 text-danger text-center">${error}</span>
    </div>

    <div class="container">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${objectTypes}" var="type">
                <tr>
                    <th scope="row">${type.id}</th>
                    <td>${type.name}</td>
                    <td>
                        <form action="delete-object-types" method="post">
                            <a class="btn btn-outline-primary" href="update-object-types/${type.id}">Update</a>
                            <input type="hidden" name="id" value="${type.id}">
                            <!--<button class="btn btn-outline-danger" type="submit">Delete</button>-->
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>