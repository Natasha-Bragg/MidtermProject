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
		<form>
			<div class="form-group row">
				<label for="staticPlayerOne" class="col-sm-2 col-form-label">Player
					One</label>
			</div>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="playerOne" value="${game.playerOne}">
			</div>
			<div class="form-group row">
				<label for="staticPlayerTwo" class="col-sm-2 col-form-label">Player
					Two</label>
			</div>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="playerTwo" value="${game.playerTwo}">
			</div>
			<div class="form-group row">
				<label for="staticStreet" class="col-sm-2 col-form-label">Street</label>
			</div>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="street" value="${user.address.street}">
			</div>
			<div class="form-group row">
				<label for="staticStreet" class="col-sm-2 col-form-label">Venue</label>
			</div>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="street" value="${game.venue}">
			</div>
			<div class="form-group row">
				<div class="col">
					<label for="staticCity" class="col-sm-2 col-form-label">City</label>
				</div>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="city" value="${user.address.city}">
				</div>
				<div class="col">
					<label for="staticState" class="col-sm-2 col-form-label">State</label>
				</div>
				<div class="col-sm-10">
					<input type="text" readonly class="form-control-plaintext"
						id="city" value="${user.address.state}">
				</div>
			</div>
			<div class="form-group row">
				<label for="staticDate" class="col-sm-2 col-form-label">Date</label>
			</div>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="staticEmail" value="${game.date}">
			</div>
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<a class="btn btn-light my-2 my-sm-0" role="button" href="home.do">Cancel</a>
				</div>
				<div class="col">
					<a class="btn btn-light my-2 my-sm-0" role="button"
						href="updateGame.do">Update Game</a>
				</div>
			</div>
		</form>
		<br>
	</div>
</body>
</html>