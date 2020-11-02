<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Player Profile</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="navbar-brand mx-auto" href="home.do"><img src="logo.png" width="30" height="30" alt="logo" loading="lazy"></a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="#"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="btn btn-light my-2 my-sm-0" role="button" href="logout.do">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<br>
<div class="container-fluid">
<h1>Profile</h1>
<c:if test="${! empty user}">
<form>
<div class="form-group row">
<label for="firstName" class="col-sm-2 col-form-label">First Name</label>
</div>
<div class="col-sm-10">
<input type="text" class="form-control" id="firstName" value="${user.firstName}" readonly>
</div>
<div class="form-group row">
<label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="lastName" value="${user.lastName}" readonly>
</div>
<div class="form-group row">
<label for="street" class="col-sm-2 col-form-label">Street</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="street" value="${user.address.street}" readonly>
</div>
<div class="form-group row">
<div class="col">
<label for="city" class="col-sm-2 col-form-label">City</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="city" value="${user.address.city}" readonly>
</div>
<div class="col">
<label for="state" class="col-sm-2 col-form-label">State</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="state" value="${user.address.state}" readonly>
</div>
</div>
<div class="form-group row">
<label for="email" class="col-sm-2 col-form-label">Email</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="email" value="${user.email}" readonly>
</div>
<div class="form-group row">
<label for="password" class="col-sm-2 col-form-label">Password</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="password" value="${user.password}" readonly>
</div>
<div class="form-group row" class="col-sm-10" class="form-check">
<c:choose>
<c:when test="${user.host} = 1">
<input type="checkbox" id="host" value="" checked readonly>
</c:when>
<c:otherwise test="${user.host} = 0">
<input type="checkbox" id="host" value="" readonly>
</c:otherwise>
</c:choose>
</div>
<div>
<label for="host" class="col-sm-2 col-form-label">Host</label>
</div>
<div class="form-group row" class="col-sm-10" class="form-check">
<c:choose>
<c:when test="${user.travel} = 1">
<input type="checkbox" id="travel" value="" checked readonly>
</c:when>
<c:otherwise test="${user.travel} = 0">
<input type="checkbox" id="travel" value="" readonly>
</c:otherwise>
</c:choose>
</div>
<div>
<label for="travel" class="col-sm-2 col-form-label">Travel</label>
</div>
<div class="form-group row">
<label for="skillLevel" class="col-sm-2 col-form-label">SkillLevel</label>
</div>
<div class="col-sm-10">
<input type="text"   class="form-control" id="skillLevel" value="${user.skillLevel.level_name}" readonly>
</div>
<div class="row">
<div class="col">
</div>
<div class="col">
<a class="btn btn-light my-2 my-sm-0" role="button" href="deleteProfile.do">Delete Profile</a>
</div>
<div class="col">
<a class="btn btn-light my-2 my-sm-0" role="button" href="updateProfile.do">Update Profile</a>
</div>
</div>
</form>
</c:if>
<br>
</div>
</body>
</html>