<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hola doctor ${ doctTemp.user.firstName }</h1>
	
	<h2>con el paciente ${ patientTemp.user.firstName }</h2>

	<a href="/treatment">new Treatment</a> <br>
	<a href="/physical">new Physical Details</a> <br>
	<a>new Medical Antecedent</a> <br>
	<a href="/existConsult">Finish Asessment</a>
</body>
</html>