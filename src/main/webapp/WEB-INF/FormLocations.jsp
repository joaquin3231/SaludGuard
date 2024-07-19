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

	<div>
		<form:form action="/location/save" method="POST" modelAttribute="location" >
			<div>
				<form:label path="address">Direccion: </form:label>
				<form:input path="address" class="form-control"/>
				<form:errors path="address" class="text-danger"/>
			</div>
			
			<div>
				<form:label path="city"></form:label>
				<form:select path="city" class="form-select" id="selectLocation">
					<c:forEach items="${provinciasResp.provincias}" var="provincia">
						<form:option value="${provincia.nombre}" id="${ provincia.id }">${provincia.nombre}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div>
				<form:label path="state">Género con el que se identifica:</form:label>
				<form:select path="state" class="form-select" id="selectMunicipios">
				</form:select>
			</div>
			

			
			<input type="submit" class="btn btn-dark mt-3" value="Registrar" >
		</form:form>
		
	</div>


<script src="../js/changeLocationSelect.js"></script>
</body>
</html>