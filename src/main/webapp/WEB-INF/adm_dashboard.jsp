<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/dashboard_adm.css">
<meta charset="ISO-8859-1">
<title>Panel de administradores</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap"
	rel="stylesheet">
</head>
<body class="radio-canada-big-body">
	<nav class="navbar navbar-custom navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img id="logo1"
				src="../img/login_adm/logosaludguardadmin.png" width="175"
				alt="Logo"> <span class="ms-2"> |   Panel de
					administradores</span>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><span class="admData">
							Administrador: ${adminInSession.name}   </span> <a id="logout"
						class="btn btn-custom" href="/admin/logout">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container d-flex justify-content-center align-items-center">
		<header class="justify-content-between">
			<h1 class="mt-3">Bienvenido, administrador</h1>
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<h3>
				Fecha y hora:
				<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
					value="${now}" />
			</h3>
		</header>
	</div>

	<div class="row justify-content-center">
		<div
			class="m-3 col-md-4 form-container d-flex flex-column justify-content-center">
			<div class="tinside">
				<h3>Registrar un nuevo usuario (profesional):</h3>
				<a class="btn btn-warning" href="/register/prof">Registrar</a>
			</div>
		</div>

		<div
			class="m-3 col-md-4 form-container d-flex flex-column justify-content-center">
			<div class="tinside">
				<h3>Modificar un usuario ya existente:</h3>
				<form:form action="/admin/searchuser" method="post"
					modelAttribute="user" class="formDni">
					<label for="userDNI"><span>DNI:</span></label>
					<form:input path="userDNI" id="userDNI" />
					<button type="submit" class="btn btn-info mt-3">Buscar</button>
				</form:form>

				<c:choose>
					<c:when test="${not empty searchResult}">
						<h2>User Details</h2>
						<p>ID: ${searchResult.id}</p>
						<p>Nombre: ${searchResult.firstName}</p>
						<p>Email: ${searchResult.email}</p>
					</c:when>
					<c:otherwise>
						<p>No user found.</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>