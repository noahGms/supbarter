<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="min-height: 100%; min-height: 100vh; display: flex; align-items: center;">
    <div class="container" style="display: flex; justify-content: center;">
        <form action="register" method="post" style="width: 600px !important;">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="text" name="email" placeholder="Email address" class="form-control">
            </div>
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" name="username" placeholder="Username" class="form-control">
            </div>
            <div class="mb-3">
                <label for="firstname" class="form-label">Firstname</label>
                <input type="text" name="firstname" placeholder="Firstname" class="form-control">
            </div>
            <div class="mb-3">
                <label for="lastname" class="form-label">Lastname</label>
                <input type="text" name="lastname" placeholder="Lastname" class="form-control">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <div class="mb-3">
                <label for="passwordConfirmation" class="form-label">Password confirmation</label>
                <input type="password" name="passwordConfirmation" placeholder="Password confirmation" class="form-control">
            </div>
            <div class="mb-3">
                <label for="zipCode" class="form-label">Zipcode</label>
                <input type="text" name="zipCode" placeholder="Zipcode" inputmode="number" pattern="^(?(^00000(|-0000))|(\d{5}(|-\d{4})))$" class="form-control">
            </div>

            <div class="mb-3 text-center">
                <span class="fs-3 text-danger text-center">${error}</span>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-primary full">Register</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>