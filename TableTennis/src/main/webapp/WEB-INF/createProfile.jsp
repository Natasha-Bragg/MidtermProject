<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Profile</title>
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
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light bg-light">
		<div
			class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="navbar-brand mx-auto"
					href="#"><img src="logo.png" width="30" height="30" alt="logo"
						loading="lazy"></a></li>
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
					role="button" href="login.do">Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">
		<h1 class="text-center">Create Your Player Profile</h1>
		<br>
		<form action="createProfile.do" method="GET">
			First Name: <input type="text" name="firstName" value="" /> <br>
			Last Name: <input type="text" name="lastName" value="" /> <br>
			Street: <input type="text" name="street" value="" /> <br> City:
			<input type="text" name="city" value="" /> <br> State: <input
				type="text" name="state" value="" maxlength="2" /> <br> Zip Code: <input
				type="text" name="zip" value="" /> <br> Email: <input
				type="text" name="email" value="" /> This will be your username <br>
			Password: <input type="text" name="password" value="" /> <br>
			<input type="hidden" name="host" value="false"/>
			Host?: <input type="checkbox" name="host" /><br>
			<input type="hidden" name="travel" value="false"/>
			Travel?: <input type="checkbox" name="travel" /><br>
			<label for="skillLevel">Skill Level</label>
			<c:if test="${! empty skillLevels }">
				<select class="custom-select" name="skillLevelId">
					<c:forEach var="skillLevel" items="${skillLevels}">
								<option value="${skillLevel.id}">${skillLevel.levelName}</option>
					</c:forEach>
				</select>
			</c:if>

			<button class="btn btn-outline-primary" type="submit" name="id" value="0">Submit</button>
		</form>
	</div>
</body>
</html>