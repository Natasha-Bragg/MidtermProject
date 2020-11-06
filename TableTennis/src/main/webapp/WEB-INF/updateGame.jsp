<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Game</title>
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
					role="button" href="viewYourProfile.do">View Your Profile</a></li>
			</ul>
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
		<form:form action="updateGame.do" modelAttribute="game">
			<input type="hidden" name="id" value="${game.id}" />
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="staticPlayerOne">Player One</label> <input type="text"
						class="form-control" id="playerOne"
						value="${game.playerOne.firstName} ${game.playerOne.lastName}"
						name="game.playerOne" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="staticPlayerTwo">Player Two</label> <input type="text"
						class="form-control" id="playerTwo"
						value="${game.playerTwo.firstName} ${game.playerOne.lastName}"
						name="game.playerTwo" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="staticStreet">Venue</label> <input type="text"
						class="form-control" id="street" value="${game.venue}"
						name="venue" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="staticStreet">Street</label> <input type="text"
						class="form-control" id="street" value="${user.address.street}"
						name="address.street" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="staticCity">City</label> <input type="text"
						class="form-control" id="city" value="${user.address.city}"
						name="address.city" readonly>
				</div>
				<div class="form-group col-md-3">
					<label for="staticState">State</label> <input type="text"
						id="state" maxlength="2" class="form-control"
						value="${user.address.state}" name="address.state" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="staticDate">Date</label> <input type="text"
						class="form-control" id="staticEmail" value="${game.gameTime}"
						name="gameTime" readonly>
				</div>
			</div>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="result">Result</label> <input type="text"
				class="form-control" id="result" value="${game.result}"
				name="result">
		</div>
	</div>
	<div class="row">
		<div class="col">
			<a class="btn btn-outline-primary my-2 my-sm-0" role="button" 
			href="home.do">Cancel</a> 
			<input class="btn btn-outline-primary my-2 my-sm-0" type="submit"
				value="Update Game" /> 
			<a class="btn btn-outline-primary my-2 my-sm-0" role="button"
				href="deleteGame.do">Delete Game</a>
		</div>
	</div>
	</form:form>
	<br>
</body>
</html>