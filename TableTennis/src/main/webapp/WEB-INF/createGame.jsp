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
<title>Create Game</title>
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
					role="button" href="viewYourProfile.do?${sessionScope.loginUser.email}">View Your Profile</a></li>
				<li class="nav-item"><a class="btn btn-light my-2 my-sm-0"
					role="button" href="logout.do">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container-fluid">
		<h1 class="text-center">Organize Your Game</h1>
		<br>
		<c:if test="${! empty opponent}">
			<form action="createGame.do" method="POST">
				<input type="hidden" name="oppId" value="${opponent.id}">
				<%-- Player One: <br> <input type="text" readonly name="playerOne" id="${opponent}" placeholder="${opponent.firstName} ${opponent.lastName}"/> <br>
			Player Two: <br> <input type="text" readonly name="playerTwo" id="${sessionScope.loginUser}" placeholder="${sessionScope.loginUser.firstName} ${sessionScope.loginUser.lastName}"/> <br> --%>
				<label>Opponent: ${opponent.firstName} ${opponent.lastName}</label><br>
				 <label>Challenger: ${sessionScope.loginUser.firstName} ${sessionScope.loginUser.lastName}</label><br>
				 Venue: <br> <input type="text" name="venue" value=""/> <br>
				 Street: <br> <input type="text" name="street" value=""/> <br> 
				 City: <br> <input type="text" name="city" value=""/> <br> 
				 State: <br> <input type="text" name="state" value="" /> <br>
				<fmt:parseDate value="${game.gameTime}" type="date"
					pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" />
				<fmt:formatDate type="both" value="${parsedDate}" />
				Date: <br> <input type="datetime-local" name="gameTime" value="${game.gameTime}"/> 
<!-- 				Date: <br> <input type="datetime-local" name="dateTime" /> <br>
 -->				<!-- Time: <br> <input type="text" name="time" /> -->
				<br> <br>
				<button class="btn btn-outline-primary" type="submit" name="id"
					value="0">Submit</button>
			</form>
		</c:if>
	</div>
	<br>
</body>
</html>