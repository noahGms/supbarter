<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SUPBARTER | MY PROFILE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../Layout/header.jsp"></jsp:include>
<div style="margin-top: 100px;" class="container">
    <h1 class="mb-3">Update my profile</h1>

    <form action="${sessionScope.contextPath}/update-user" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="text" name="email" value="${sessionScope.currentUser.email}" placeholder="Email address" class="form-control">
        </div>
        <div class="mb-3">
            <label for="firstname" class="form-label">Firstname</label>
            <input type="text" name="firstname" value="${sessionScope.currentUser.firstname}" placeholder="Firstname" class="form-control">
        </div>
        <div class="mb-3">
            <label for="lastname" class="form-label">Lastname</label>
            <input type="text" name="lastname" value="${sessionScope.currentUser.lastname}" placeholder="Lastname" class="form-control">
        </div>
        <div class="mb-3">
            <label for="zipcode" class="form-label">Zipcode</label>
            <input type="text" name="zipcode" value="${sessionScope.currentUser.zipcode}" placeholder="Zipcode" class="form-control">
        </div>
        <div class="mb-3">
            <label for="currentPassword" class="form-label">Current password</label>
            <input type="text" name="currentPassword" placeholder="Current password" class="form-control">
        </div>
        <div class="mb-3">
            <label for="newPassword" class="form-label">New password</label>
            <input type="text" name="newPassword" placeholder="New password" class="form-control">
        </div>
        <div class="mb-3">
            <label for="newPasswordConfirmation" class="form-label">New password confirmation</label>
            <input type="text" name="newPasswordConfirmation" placeholder="New password confirmation" class="form-control">
        </div>

        <div class="mb-3 text-center">
            <span class="fs-3 text-danger text-center">${error}</span
        </div>

        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary full">Update</button>
        </div>
    </form>
</div>
</body>
</html>
