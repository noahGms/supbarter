<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | SHOW AN OBJECT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Object n°${object.id} | <span class="text-uppercase">${object.title}</span></h1>

    <div class="mb-3 text-center">
        <span class="fs-3 text-danger text-center">${error}</span>
    </div>

    <div class="container">
        <div class="row" style="margin-top: 70px;">
            <div class="col-md-8">
                <img height="750px" width="500px" class="img-fluid" src="${object.picture}" alt="">
            </div>
            <div class="col-md-4">
                <h3 class="my-3">Project Description</h3>
                <p>${object.description}</p>
                <h3 class="my-3">Project Details</h3>
                <ul>
                    <li>type : ${object.type.name}</li>
                    <li>price : ${object.price} €</li>
                    <li>sold by : ${object.user.username}</li>
                </ul>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary full">Buy</button>
                </div>

                <c:if test="${currentUser.id == object.user.id}">
                    <div class="container">
                        <form class="mt-3" action="${sessionScope.contextPath}/delete-objects" method="post">
                            <input type="hidden" name="id" value="${object.id}">
                            <div class="row">
                                <div class="col">
                                    <div class="d-grid gap-2">
                                        <a href="${sessionScope.contextPath}/update-objects/${object.id}"
                                           class="btn btn-outline-primary">Update</a>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="d-grid gap-2">
                                        <button type="submit" class="btn btn-outline-danger">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>