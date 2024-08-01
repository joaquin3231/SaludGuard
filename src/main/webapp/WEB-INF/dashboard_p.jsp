<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Panel para pacientes</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<style>
*{
	margin: 0;
	padding: 0;
	border: 0;
}

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

.table {
    background-color: rgba(255, 255, 255, 0.1); /* fondo blanco con 10% de opacidad */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* sombra gris con 20% de opacidad */
    backdrop-filter: blur(5px); /* filtro de blur para darle un efecto de acrílico */
  }

body {
    background-image: url('../img/background1.png');
    background-position: center;
}
</style>
<body class="radio-canada-big-body">
    <div>
        <nav class="navbar navbar-custom navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img id="logo1" src="../img/logosaludguardwhite.png" width="200" alt="Logo">
					<span class="ms-2"> |   Panel del paciente</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a id="logout" class="btn btn-custom" href="/logout">Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container mt-5">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="mb-4">Bienvenid@ a SaludGuard, ${userInSession.firstName}</h1>
                        <h2 class="mb-4">Consultas de mi historia clínica</h2>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
										<th><i class="fas fa-calendar-alt fa-sm"></i> Fecha de consulta</th>
										<th><i class="fas fa-user-md fa-sm"></i> Profesional</th>
										<th><i class="fas fa-sticky-note fa-sm"></i> Observaciones</th>
										<th><i class="fas fa-info-circle fa-sm"></i> Más información</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${assesmentList}" var="assesment">
										<tr>
									<td>${assesment.createAt}</td>
									<td>${assesment.doctor.user.firstName}</td>
									<td>${assesment.observation}</td>
									<td> <a href="#">Más información</a> </td>
										</tr>
									</c:forEach>
                                </tbody>
                            </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>