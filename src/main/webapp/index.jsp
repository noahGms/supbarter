<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | HOME</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="Layout/header.jsp"></jsp:include>
<div class="container">
    <div class="d-flex justify-content-center">
        <h1 style="margin-top: 100px;">Welcome <c:if
                test="${sessionScope.isLogin}">${sessionScope.currentUser.username}</c:if> on SUPBARTER</h1>
    </div>
    <div class="row mt-4">
        <div class="col">
            <p>Barter is the economic transaction whereby each participant transfers ownership of one good and receives
                another good. Barter is part of the offsetting trade with the exchange of services at par.</p>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Number of objects
                </div>
                <div class="card-body">
                    <h4 class="font-weight-bold">${numberOfObjects}</h4>
                </div>
            </div>
        </div>
        <div class="col-md-6" id="numberOfUsers">
            <div class="card">
                <div class="card-header">
                    Number of users
                </div>
                <div class="card-body">
                    <h4 class="font-weight-bold">${numberOfUsers}</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-4 mb-4">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Recent objects
                </div>
                <div class="card-body">
                    <div class="container">
                        <div class="row justify-content-center">
                            <c:forEach items="${recentObjects}" var="object">
                                <div class="col-sm-3 d-flex justify-content-center mb-4">
                                    <div class="card" style="width: 18rem;">
                                        <img height="100%" width="100px" src="${object.picture}" class="card-img-top"
                                             alt="...">
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script>
    const addClass = () => {
        let el = document.getElementById("numberOfUsers");
        const className = "mt-4";
        if (window.innerWidth < 768) {
            el.classList.add(className);
        } else {
            if (el.classList.contains(className)) {
                el.classList.remove(className);
            }
        }
    }
    window.addEventListener("load", addClass);
    window.addEventListener('resize', addClass);
</script>