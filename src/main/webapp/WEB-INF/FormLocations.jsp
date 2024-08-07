<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salud guard</title>
<link rel="stylesheet" href="../css/styledashboard_p.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body class="radio-canada-big-body">

	<div>
		<nav class="navbar navbar-custom navbar-expand-lg">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img id="logo1"
					src="../img/logosaludguardwhite.png" width="200" alt="Logo">

				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a id="logout" class="btn btn-custom"
							href="/logout">Cerrar sesión</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container mt-5">
			<div class="row">
				<div class="col-md-12">
					<h1 class="mb-4">Bienvenid@ a SaludGuard,
						${userInSession.firstName}</h1>
					<h2 class="mb-4">Para continuar, por favor complete los campos
						a continuación.</h2>


					<div class="col-md-9">
						<form:form action="/location/save" method="POST"
							modelAttribute="location" class="row g-3" id="formLocation">

							<div class="col-12">
								<form:label path="address">Dirección (indique departamento/piso si es necesario):</form:label>
								<form:input path="address" class="form-control" id="address" />
								<form:errors path="address" class="text-danger" />
							</div>

							<div class="col-12">
								<form:label path="address2">Segunda dirección (opcional):</form:label>
								<form:input path="address2" class="form-control" id="address2" />
								<form:errors path="address2" class="text-danger" />
							</div>

							<div class="col-12">
								<form:label path="city">Provincia</form:label>
								<form:select path="city" class="form-select" id="selectLocation">
									<c:forEach items="${provinciasResp.provincias}" var="provincia">
										<form:option value="${provincia.nombre}"
											id="${ provincia.id }">${provincia.nombre}</form:option>
									</c:forEach>
								</form:select>
							</div>

							<div class="col-md-6">
								<form:label path="state">Municipio:</form:label>
								<form:select path="state" class="form-select"
									id="selectMunicipios">
								</form:select>
							</div>

							<div class="col-md-4">
								<form:label path="town">Localidad:</form:label>
								<form:input path="town" class="form-control" id="town" />
								<form:errors path="town" class="text-danger" />
							</div>

							<div class="col-md-2">
								<form:label path="postalCode">Código postal:</form:label>
								<form:input path="postalCode" class="form-control"
									id="postalCode" />
								<form:errors path="postalCode" class="text-danger" />
							</div>

							<input type="hidden" value="patient${userInSession.id}" id="user">

							<div class="col-12">
								<input type="submit" class="btn btn-dark mt-3" value="Registrar"
									id="enviar">
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="../js/changeLocationSelect.js"></script>
	<script src="../js/saveInfoLocation.js"></script>
</body>
</html>