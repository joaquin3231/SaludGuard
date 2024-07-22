<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel para pacientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
			<header class="d-flex justify-content-between">
				<h1>Bienvenid@, ${userInSession.firstName}!</h1>
				<a class="btn btn-danger" href="/logout" >Log out</a>
			</header>
			<div class="row">
			<h2>Consultas de mi historia clínica</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Fecha de consulta</th>
							<th>Profesional</th>
							<th>Observaciones</th>
							<th>Más información</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${assesmentList}" var="assesment">
							<tr>
								<td>${assesment.createAt}</td>
								<td>${assesment.doctor.user.firstName}</td>
								<td>${assesment.observation}</td>
								<td> <a href="#">Más información</a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</div>
</body>
</html>