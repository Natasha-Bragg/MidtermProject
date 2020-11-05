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
		<div
			class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="navbar-brand mx-auto"
					href="home.do"><img src="logo.png" width="30" height="30"
						alt="logo" loading="lazy"></a></li>
			</ul>
		</div>
		<div class="mx-auto order-0">
			<a class="navbar-brand mx-auto" href="#"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target=".dual-collapse2">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="btn btn-light my-2 my-sm-0"
					role="button" href="logout.do">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container-fluid">
		<h1>Profile</h1>
		<c:if test="${! empty user}">
			<form>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticEmail">Email</label> <input type="text"
							class="form-control" id="email" value="${user.email}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticPassword">Email</label> <input type="text"
							class="form-control" id="password" value="${user.password}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticFirstName">First Name</label> <input type="text"
							class="form-control" id="firstName" value="${user.firstName}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticLastName">Last Name</label> <input type="text"
							class="form-control" id="firstName" value="${user.lastName}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticStree">Street</label> <input type="text"
							class="form-control" id="street" value="${user.address.street}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="staticCity">City</label> <input type="text"
							class="form-control" id="city" value="${user.address.city}">
					</div>
					<div class="form-group col-md-3">
						<label for="staticState">State</label> <input type="text"
							maxlength="2" class="form-control" id="city"
							value="${user.address.state}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<div class="form-check">
							<c:choose>
								<c:when test="${user.host}">
									<input type="checkbox" id="staticHost" value="" checked>
								</c:when>
								<c:when test="${!user.host}">
									<input type="checkbox" id="staticHost" value="">
								</c:when>
							</c:choose>
							<label for="staticHost">Host</label>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<div class="form-check">
							<c:choose>
								<c:when test="${user.travel}">
									<input type="checkbox" id="staticTravel" value="" checked>
								</c:when>
								<c:when test="${!user.travel}">
									<input type="checkbox" id="staticTravel" value="">
								</c:when>
							</c:choose>
							<label for="staticTravel">Travel</label>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="staticSkillLevel">Skill Level</label>
						<c:if test="${! empty skillLevels }">
							<select class="custom-select" name="skillLevel">
								<c:forEach var="skillLevel" items="${skillLevels}">
									<c:choose>
										<c:when test="${skillLevel.id != user.skillLevel.id }">
											<option value="${skillLevel.id}">${skillLevel.levelName}</option>
										</c:when>
										<c:otherwise>
											<option value="${skillLevel.id}" selected>${skillLevel.levelName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:if>
					</div>
				</div>
				<div class="form-row">
					<ul class="list-group list-group-horizontal">
						<li><a class="btn btn-outline-primary my-2 my-sm-0"
							role="button" href="updateProfile.do">Submit Changes</a></li>
						<li><a class="btn btn-outline-primary my-2 my-sm-0"
							role="button" href="deleteProfile.do">Delete Profile</a></li>
					</ul>
				</div>
			</form>
		</c:if>
	</div>
</body>
</html>