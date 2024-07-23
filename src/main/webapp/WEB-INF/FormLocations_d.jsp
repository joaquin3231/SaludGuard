<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="d-flex justify-content-center">
			<h1>�Bienvenid@ a SaludGuard!</h1>
			<h2>Para continuar, por favor complete los campos a continuaci�n.</h2>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-md-9" >
				<form:form action="/register/prof/location/save" method="POST" modelAttribute="location" class="row g-3" id="formLocation">
				
					<div class="col-12">
						<form:label path="address">Direcci�n (indique departamento/piso si es necesario):</form:label>
						<form:input path="address" class="form-control" id="address"/>
						<form:errors path="address" class="text-danger"/>
					</div>
					
					<div class="col-12">
						<form:label path="address2">Segunda direcci�n (opcional):</form:label>
						<form:input path="address2" class="form-control" id="address2"/>
						<form:errors path="address2" class="text-danger"/>
					</div>
					
					<div class="col-12">
							<form:label path="city">Provincia</form:label>
							<form:select path="city" class="form-select" id="selectLocation">
								<c:forEach items="${provinciasResp.provincias}" var="provincia">
									<form:option value="${provincia.nombre}" id="${ provincia.id }">${provincia.nombre}</form:option>
								</c:forEach>
							</form:select>
					</div>
						
					<div class="col-md-6">
							<form:label path="state">Municipio:</form:label>
							<form:select path="state" class="form-select" id="selectMunicipios">
							</form:select>	
					</div>
					
					<div class="col-md-4">
							<form:label path="town">Localidad:</form:label>
							<form:input path="town" class="form-control" id="town"/>
							<form:errors path="town" class="text-danger"/>
					</div>
						
					<div class="col-md-2">
							<form:label path="postalCode">C�digo postal:</form:label>
							<form:input path="postalCode" class="form-control" id="postalCode"/>
							<form:errors path="postalCode" class="text-danger"/>
					</div>
					
					<input type="hidden" value="medic${idDoctor}" id="user">
					
					<div class="col-12">
						<input type="submit" class="btn btn-dark mt-3" value="Registrar"  id="enviar">
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script src="../js/changeLocationSelect.js" role="stylesheet"></script>
	<script src="../js/saveInfoLocation.js" role="stylesheet"></script>
</body>
</html>