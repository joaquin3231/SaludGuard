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
<style>
    body {
        background-image: url("../img/doc_3.png"); 
        background-size: cover;
        background-position: center;
        height: 600px;
        margin: 20px;
    }
    .form-container {
        background-color: rgba(213, 213, 213, 0.6);
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 550px; 
        margin-bottom: 20px; 
    }
</style>
</head>
<body>
	<div class="container  mt-5">
		<div class="row">
			<div class="col-12 col-md-6 mb-4">
				<div class="form-container">
				<h2 class="text-center ">Registro de administradores</h2>
				<form:form action="/admin/register" method="POST" modelAttribute="newAdmin" >
					<div class="mb-3">
						<form:label path="name" >Nombre completo:</form:label>
						<form:input path="name" class="form-control" />
						<form:errors path="name" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="email" >E-mail:</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="phone" >Número de teléfono:</form:label>
						<form:input path="phone" class="form-control" />
						<form:errors path="phone" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="userDNI" >Número de DNI:</form:label>
						<form:input path="userDNI" class="form-control" />
						<form:errors path="userDNI" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="password" >Introduzca una contraseña:</form:label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" class="text-danger"/>
					</div>
					<div class="mb-3">
						<form:label path="confirm" >Confirme su contraseña:</form:label>
						<form:password path="confirm" class="form-control" />
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<div class="text-center">
					<input type="submit" class="btn btn-success" value="Registrar como administrador" >
					</div>
				</form:form>
			</div>
			</div>
			
			<div  class="col-12 col-md-6">
				<div class="form-container">
				<h2 class="text-center ">Login</h2>
				<p class="text-danger  text-center">${errorAdminLogin}</p>
				<form action="/admin/login" method="POST">
					<div  class="mb-3">
						<label>E-mail:</label>
						<input type="email" class="form-control" name="email" >
					</div>
					<div  class="mb-3">
						<label>Contraseña:</label>
						<input type="password" class="form-control" name="password" >
					</div>
					<div class="text-center">
					<input type="submit" class="btn btn-success mt-3" value="Login" >
					</div>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>