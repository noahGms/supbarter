<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | UPDATE AN OBJECT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Update object n°${object.id}</h1>

    <form action="update-objects/${object.id}}" method="post">
        <input type="hidden" name="id" value="${object.id}">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" name="title" placeholder="Title" class="form-control" value="${object.title}">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea name="description" cols="30" rows="10" placeholder="Description" class="form-control">${object.description}</textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" min="0.01" step="0.01" name="price" placeholder="Price" class="form-control" value="${object.price}" />
        </div>
        <div class="mb-3">
            <label for="picture" class="form-label">Picture link</label>
            <input type="text" name="picture" placeholder="Picture link" class="form-control" value="${object.picture}">
        </div>
        <div class="mb-3">
            <div>
                <label for="type" class="form-label">Type</label>
                <select name="type" class="form-select">
                    <option value="">--Please choose an option--</option>
                    <c:forEach items="${objectTypes}" var="type" >
                        <option <c:if test="${type.id == requestScope.object.type.id}"> selected </c:if> value="${type.id}">${type.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="mb-3 text-center">
            <span class="fs-3 text-danger text-center">${error}</span>
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary full">Update</button>
        </div>
    </form>
</div>
</body>
</html>