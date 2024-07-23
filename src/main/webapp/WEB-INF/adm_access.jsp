<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceso administradores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Registro de administradores</h2>
				<form:form action="/admin/register" method="POST" modelAttribute="newAdmin" >
					<div>
						<form:label path="name" >Nombre completo:</form:label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div>
						<form:label path="email" >E-mail:</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div>
						<form:label path="phone" >Número de teléfono:</form:label>
						<form:input path="phone" class="form-control" />
						<form:errors path="phone" class="text-danger" />
					</div>
					<div>
						<form:label path="userDNI" >Número de DNI:</form:label>
						<form:input path="userDNI" class="form-control" />
						<form:errors path="userDNI" class="text-danger" />
					</div>
					<div>
						<form:label path="password" >Introduzca una contraseña:</form:label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" class="text-danger"/>
					</div>
					<div>
						<form:label path="confirm" >Confirme su contraseña:</form:label>
						<form:password path="confirm" class="form-control" />
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Registrar como administrador" >
				</form:form>
			</div>
			<div class="col-6">
				<h2>Login</h2>
				<p class="text-danger">${errorAdminLogin}</p>
				<form action="/admin/login" method="POST">
					<div>
						<label>E-mail:</label>
						<input type="email" class="form-control" name="email" >
					</div>
					<div>
						<label>Contraseña:</label>
						<input type="password" class="form-control" name="password" >
					</div>
					<input type="submit" class="btn btn-info mt-3" value="Login" >
				</form>
			</div>
		</div>
	</div>
</body>
</html>