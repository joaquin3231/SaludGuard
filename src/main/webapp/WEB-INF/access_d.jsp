<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceso a profesionales</title>
<link rel="stylesheet" href="../css/style2.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div>
		<div class="row align-items-center">
			<div class="col-sm">
                <img id="img1" src="../img/imgregd.png" />
			</div>
			<div class="col-sm">
				<img id="img2" src="../img/logosug4.png" width=35% />
				<h2>Acceder al panel (para profesionales)</h2>
				<div class="col-md-9">
					<p class="text-danger">${errorLogin}</p>
					<form action="/login" method="POST">
						<div>
							<label>DNI (sin puntos ni espacios):</label>
							<input type="text" class="form-control" name="userDNI" >
						</div>
						<div>
							<label>Contraseña:</label>
							<input type="password" class="form-control" name="password" >
						</div>
						<input type="submit" class="btn btn-success mt-3" value="Acceder" >
					</form>
				</div>
				<br>
				<div>
					<h5>¿Olvidó su contraseña? <a href="#">Por favor clickee aquí para restablecerla.</a></h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>