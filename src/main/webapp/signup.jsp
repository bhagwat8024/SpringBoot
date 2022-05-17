<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	xmlns:th="http://www.thymeleaf.org">
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="login.css" rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
</head>
<body>
	<main class="container-fluid">
		<div class="login_container container">
			<form class="border login_form" action="SignUpModule" method="POST">
				<div class="row mb-3">
					<label for="username" class="col-12 col-sm-2 col-form-label">UserName</label>
					<div class="col-12 col-sm-10">
						<input type="text" class="form-control is-invalid" name="username"
							id="username" maxlength="20" required>
						<div id="validationServer04Feedback" class="invalid-feedback">
							<form:errors path="user.username" />
						</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="password" class="col-12 col-sm-2 col-form-label">Password</label>
					<div class="col-12 col-sm-10">
						<input type="password" class="form-control is-invalid" name="password"
							id="password" maxlength="30" required>
						<div id="validationServer04Feedback" class="invalid-feedback">
							<form:errors path="user.password" />
						</div>
					</div>
				</div>

				<button type="submit" class="btn btn-primary btn-block mb-4">Sign
					Up</button>
			</form>
		</div>
	</main>
</body>
</html>