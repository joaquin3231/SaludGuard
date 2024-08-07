<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Confirmación</title>
</head>
<style>
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
	font-weight: 700
}

.radio-canada-big-body {
	font-family: "Radio Canada Big", sans-serif;
	font-optical-sizing: auto;
	font-weight: 500;
	font-style: normal;
}

.table {
	background-color: rgba(255, 255, 255, 0.1);
	/* fondo blanco con 10% de opacidad */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	/* sombra gris con 20% de opacidad */
	backdrop-filter: blur(5px);
	/* filtro de blur para darle un efecto de acrílico */
}

body {
	background-image: url('../img/background1.png');
	background-position: center;
}

#regtextdoc {
	display: inline-block;
	color: white;
}
</style>
<body class="radio-canada-big-body">
	<nav class="navbar navbar-custom navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <span id="regtextdoc">SaludGuard
					| Registro de profesionales</span>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a id="logout" class="btn btn-custom"
						href="/logout">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="mt-2 container">
		<form action="/save/prof" method="POST" class="row g-3"
			id="formLocation">

			<div class="col-12">
				<label>Número de Matrícula:</label> <input name="medLicense"
					type="text" required="required" class="form-control" id="address" />
			</div>

			<input type="hidden" value="${userInSession.id}" id="user">

			<div class="col-12">
				<input type="submit" class="btn btn-dark mt-3" value="Registrar">
			</div>
		</form>
	</div>
</body>
</html>