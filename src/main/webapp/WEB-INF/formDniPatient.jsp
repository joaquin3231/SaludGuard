<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<p class="text-danger">${errorFind}</p>
		<form action="/getPatient" method="POST">
			<label>DNI del paciente a tratar</label>
			<input type="text" placeholder="dni paciente" name="dniPaciente" required="required">
			<input type="submit" value="enviar">
		</form>
	</div>

</body>
</html>