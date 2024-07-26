<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel de profesionales</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap" rel="stylesheet">
</head>
<style>
@charset "ISO-8859-1";

.navbar-custom {
    background-color: #1C3B40;
}

#logout {
    background-color: #90ee90; /* Replace with your desired color */
    border-color: #90ee90; /* Replace with your desired color */
    color: #000000; /* Replace with your desired text color */
}

.ms-2 {
    color: white;
    font-weight:700
}

.radio-canada-big-body {
  font-family: "Radio Canada Big", sans-serif;
  font-optical-sizing: auto;
  font-weight: 500;
  font-style: normal;
}

 .form-container {
        background-color: rgb(244, 244, 244);
        padding: 5vw; 
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 35vw;
        align-items: middle;
        justify-content: center;
        text-align: center;
}

.input{
	border-radius: 5px;
	border: 1px solid #000000;
}

.doctorData {
	color: white;
	display: inline-block;
}
</style>
<body class="radio-canada-big-body">
	<nav class="navbar navbar-custom navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img id="logo1" src="../img/login_adm/logosaludguardadmin.png" width="175" alt="Logo">
					<span class="ms-2"> |   Panel de profesionales</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                        	<span class="doctorData">${doctTemp.user.lastName}, ${doctTemp.user.firstName} | MM.NN: ${doctTemp.medLicense}       </span>
                            <a id="logout" class="btn btn-custom" href="/admin/logout">Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
     </nav>
    
	<div class="row mt-5 vh-90 vw-35 justify-content-center align-items-center">
		<div class="text-center mb-3">
			<h4>Le damos la bienvenida a SaludGuard, ${doctTemp.user.firstName}</h4>
			<c:set var="now" value="<%= new java.util.Date()%>" />
			<h5>Fecha y hora: <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" /></h5>
		</div>
		<div class="form-container">
			<p class="text-danger">${errorFind}</p>
			<form action="/getPatient" method="POST">
				<label>Número de DNI del paciente a tratar (sin puntos ni espacios):</label>
				<input class="mt-2 input" type="text" placeholder="DNI" name="dniPaciente" required="required">
				<input type="submit" class="mt-2 btn btn-dark" value="Confirmar y comenzar consulta"></input>
			</form>
		</div>
	</div>

</body>
</html>