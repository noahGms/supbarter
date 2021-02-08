<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | ADD AN OBJECT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Add an object</h1>

    <form action="add-objects" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <input type="text" name="title" placeholder="Title" class="form-control">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea name="description" cols="30" rows="10" placeholder="Description" class="form-control"></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" min="0.01" step="0.01" name="price" placeholder="Price" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="picture" class="form-label">Picture link</label>
            <input type="text" name="picture" placeholder="Picture link" class="form-control">
        </div>
        <div class="mb-3">
            <label for="type" class="form-label">Type</label>
            <select name="type" class="form-select">
                <option value="">--Please choose an option--</option>
                <c:forEach items="${objectTypes}" var="type" >
                    <option value="${type.id}">${type.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3 text-center">
            <span class="fs-3 text-danger text-center">${error}</span
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary full">Add</button>
        </div>
    </form>
</div>
</body>
</html>