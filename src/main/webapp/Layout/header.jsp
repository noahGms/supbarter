<%--
  Created by IntelliJ IDEA.
  User: noah
  Date: 08/02/2021
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="${sessionScope.contextPath}">SupBarter</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
                    aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${sessionScope.contextPath}">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${sessionScope.contextPath}/objects">Objects</a>
                    </li>
                    <c:if test="${ sessionScope.isLogin }">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${sessionScope.contextPath}/object-types">Types</a>
                        </li>
                    </c:if>
                </ul>

                <div class="d-flex justify-content-between">
                    <form class="d-flex" action="search" method="post">
                        <!--<button class="btn btn-outline-success" type="submit">Search</button>-->
                        <input class="form-control me-2" type="search" name="searchText" placeholder="Search" aria-label="Search">
                    </form>
                    <c:if test="${!sessionScope.isLogin}">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="${sessionScope.contextPath}/login">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="${sessionScope.contextPath}/register">Register</a>
                            </li>
                        </ul>
                    </c:if>
                    <c:if test="${sessionScope.isLogin}">
                        <div class="d-flex ml-3">
                            <a class="btn btn-outline-dark btn-small me-2" href="${sessionScope.contextPath}/my-objects">My objects</a>
                            <a class="btn btn-outline-dark btn-small me-2" href="${sessionScope.contextPath}/update-user">My profile</a>
                            <form action="logout" method="post">
                                <button class="btn btn-small btn-outline-danger" type="submit">Logout</button>
                            </form>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>
</header>
