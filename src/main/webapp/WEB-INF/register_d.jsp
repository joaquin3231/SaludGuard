<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de profesionales</title>
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
<link rel="stylesheet" href="../css/style1.css">
</head>
<body class="radio-canada-big-body">
	<div>
		<div class="row align-items-center">
			<div class="col-sm">
				<img id="img1" src="../img/regpic2.png" />
			</div>
			<div class="col-sm">
				<img id="img2" src="../img/logosug4.png" width=35% />
				<h2>Registro de profesional</h2>
				<div class="col-md-9">
					<form:form action="/register/prof" method="POST"
						modelAttribute="newUser">
						<div>
							<form:label path="firstName">Nombre:</form:label>
							<form:input path="firstName" class="form-control" />
							<form:errors path="firstName" class="text-danger" />
						</div>
						<div>
							<form:label path="lastName">Apellido:</form:label>
							<form:input path="lastName" class="form-control" />
							<form:errors path="lastName" class="text-danger" />
						</div>
						<div>
							<form:label path="email">E-mail:</form:label>
							<form:input path="email" class="form-control" />
							<form:errors path="email" class="text-danger" />
						</div>
						<div>
							<form:label path="phone">N�mero de tel�fono:</form:label>
							<form:input path="phone" class="form-control" />
							<form:errors path="phone" class="text-danger" />
						</div>
						<div>
							<form:label path="userDNI">N�mero de DNI:</form:label>
							<form:input path="userDNI" class="form-control" />
							<form:errors path="userDNI" class="text-danger" />
						</div>
						<div>
							<form:label path="gender">G�nero:</form:label>
							<form:select path="gender" class="form-select">
								<c:forEach items="${genders}" var="genders">
									<form:option value="${genders}">${genders}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<div>
							<form:label path="password">Clave:</form:label>
							<form:password path="password" class="form-control" />
							<form:errors path="password" class="text-danger" />
						</div>
						<div>
							<form:label path="confirm">Confirmaci�n de la clave:</form:label>
							<form:password path="confirm" class="form-control" />
							<form:errors path="confirm" class="text-danger" />
						</div>
						<input type="submit" class="btn btn-dark mt-3" value="Registrar">
					</form:form>
				</div>
				<br>
			</div>
		</div>
	</div>
</body>
</html>