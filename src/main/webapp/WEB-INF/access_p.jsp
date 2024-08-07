<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso a pacientes</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="radio-canada-big-body">
	<div>
		<div class="row align-items-center">
			<div class="col-sm">
				<img id="img1" src="../img/login_pac.png" />
			</div>
			<div class="col-sm">
				<img id="img2" src="../img/logosug4.png" width=35% />
				<h2>Acceso a su historial</h2>
				<div class="col-md-9">
					<p class="text-danger">${errorLogin}</p>
					<form action="/login" method="POST">
						<div>
							<label>E-mail:</label> <input type="email" class="form-control"
								name="email">
						</div>
						<div>
							<label>Contraseña:</label> <input type="password"
								class="form-control" name="password">
						</div>
						<input type="submit" class="btn btn-success mt-3" value="Acceder">
						<a class="btn btn-outline-success mt-3" href="/" role="button">Crear
							nueva cuenta</a>
					</form>
				</div>
				<br>
				<div>
					<h6>
						¿Olvidó su contraseña? <a href="#">Restablézcala aquí.</a>
						</h4>
				</div>
			</div>
		</div>
	</div>
</body>
</html>