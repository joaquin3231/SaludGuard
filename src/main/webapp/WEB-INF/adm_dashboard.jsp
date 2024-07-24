<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de administradores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<div class="container d-flex justify-content-center align-items-center"  style="height: 600px;">
		<header class="d-flex justify-content-between">
		<h1 class="text-center ">Bienvenido Administrador</h1>
		<a class="btn btn-danger" href="/admin/logout" >Log out</a>
		</header>
		<c:set var="now" value="<%= new java.util.Date()%>" />
		<h2>Fecha y hora: <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" /></h2>
		
		<h3>Registras un nuevo usuario (profesional):</h3>
		<a class="btn btn-warning" href="/register/prof">Registrar</a>
		
	 	<h3>Modificar un usuario ya existente:</h3>
		 <form:form action="/admin/searchuser" method="post" modelAttribute="user">
	        <label for="userDNI">DNI:</label>
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
</body>
</html>