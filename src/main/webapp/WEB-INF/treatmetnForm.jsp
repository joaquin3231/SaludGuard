<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>treatment</title>
</head>
<body>

	<div>
		<form:form action="/treatment/save" method="POST" modelAttribute="treatmentNew">
		
			<div>
				<form:label path="type">Tipo de tratamiento:</form:label>
				<form:input path="type"/>
				<form:errors path="type"/>
			</div>
			
			<div>
				<form:label path="description">Descripcion del tratamiento</form:label>
				<form:textarea path="description"/>
				<form:errors path="description"/>
			</div>
			
			<input type="submit" value="guardar">
		</form:form>
	</div>

</body>
</html>