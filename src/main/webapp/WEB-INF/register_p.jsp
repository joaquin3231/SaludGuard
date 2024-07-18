<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de pacientes</title>
<link rel="stylesheet" href="../css/style1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div>
		<div class="row align-items-center">
			<div class="col-sm">
                <img id="img1" src="../img/regpic1.png" />
			</div>
			<div class="col-sm">
				<img id="img2" src="../img/logosug4.png" width=35% />
				<h2>Registro de paciente</h2>
				<form:form action="/register" method="POST" modelAttribute="newUser" >
					<div>
						<form:label path="firstName" >Nombre:</form:label>
						<form:input path="firstName" class="form-control" />
						<form:errors path="firstName" class="text-danger" />
					</div>
					<div>
						<form:label path="lastName" >Apellido:</form:label>
						<form:input path="lastName" class="form-control" />
						<form:errors path="lastName" class="text-danger" />
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
						<form:label path="gender">Género con el que se identifica:</form:label>
						<form:select path="gender" class="form-select">
							<c:forEach items="${genders}" var="genders">
								<form:option value="${genders}">${genders}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div>
						<form:label path="password" >Escriba una contraseña:</form:label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" class="text-danger"/>
					</div>
					<div>
						<form:label path="confirm" >Confirme su contraseña:</form:label>
						<form:password path="confirm" class="form-control" />
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<input type="submit" class="btn btn-dark mt-3" value="Registrar" >
				</form:form>
				<br>
				<div>
					<h6>¿Ya tiene usuario? <a href="/prueba">Ingrese aquí.</a></h4>
				</div>
			</div>
		</div>
	</div>
</body>
</html>