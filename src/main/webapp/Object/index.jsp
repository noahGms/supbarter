<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | OBJECTS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Objects
        <c:if test="${sessionScope.isLogin}">
            <a href="add-objects" class="btn btn-primary">Add</a>
        </c:if>
    </h1>

    <div class="mb-3 text-center">
        <span class="fs-3 text-danger text-center">${error}</span>
        <span class="fs-3 text-danger text-center">${sessionScope.updateObjectError}</span>
    </div>

    <div class="container">
        <div class="row">
            <c:forEach items="${objects}" var="object">
                <div class="col-sm-3 d-flex justify-content-center mb-4">
                    <div class="card" style="width: 18rem;">
                        <img height="100%" width="100px" src="${object.picture}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${object.title}</h5>
                            <p class="card-text">${object.description}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">type : ${object.type.name}</li>
                            <li class="list-group-item">price : ${object.price} €</li>
                            <li class="list-group-item">sold by : ${object.user.username}</li>
                        </ul>
                        <div class="card-body">
                            <a href="show-objects/${object.id}">More details</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row mb-4">
            <div class="col">
                <form class="pagination justify-content-center" action="${sessionScope.contextPath}/objects" method="post">
                    <c:forEach var="i" begin="1" end="${pageNumber}" step="1">
                        <input type="submit" name="pageNumber" value="${i}" class="page-link">
                    </c:forEach>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>