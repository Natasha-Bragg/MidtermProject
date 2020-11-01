<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form>
		<div class="container">
			<label>E-mail : </label> <input type="text"
				placeholder="Enter E-mail" name="username" required> <label>Password
				: </label> <input type="password" placeholder="Enter Password"
				name="password" required>
			<button type="submit">Login</button>
			<input type="checkbox" checked="checked"> Remember me
			<button type="button" class="cancelbtn">Cancel</button>
			Forgot <a href="#"> password? </a>
		</div>
	</form>

</body>
</html>