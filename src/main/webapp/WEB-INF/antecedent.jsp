<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap"
	rel="stylesheet">
<title>Antecedentes m�dicos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.radio-canada-big-body {
	font-family: "Radio Canada Big", sans-serif;
	font-optical-sizing: auto;
	font-weight: 500;
	font-style: normal;
}

body {
	margin: 0;
	height: 700px;
	display: flex;
	flex-direction: column;
	overflow: hidden;
}

.header {
	display: flex;
	align-items: center;
	background-color: rgb(31, 152, 111);
	padding: 10px 20px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.header img {
	height: 50px;
	margin-right: 20px;
}

.content {
	display: flex;
	flex: 1;
	height: calc(700px - 70px);
}

.image-section {
	flex: 1.5;
	background: url('../img/histo.png') no-repeat center center;
	background-size: cover;
	height: 100vh;
}

.form-section {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: rgb(234, 234, 234);
	height: 100vh;
}

.form-container {
	background-color: rgba(213, 213, 213, 0.8);
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 500px;
	max-width: 550px;
	min-height: 550px;
	align-items: center;
	justify-content: center;
}

.form-container .mb-3 {
	width: 100%;
}

.form-container .form-control {
	margin-top: 10px;
}

.form-container .btn {
	margin-top: 20px;
}
</style>
</head>
<body class="radio-canada-big-body">
	<div class="header">
		<img src="../img/logosaludguardwhite.png" alt="Logo">
	</div>
	<div class="content">
		<div class="image-section"></div>
		<div class="form-section">
			<div class="form-container">
				<h2 class="text-center">A�adir antecedente m�dico</h2>
				<form:form action="/antecedent/save" method="POST"
					modelAttribute="antecedent">
					<div class="mb-3">
						<form:label path="type">Tipo:</form:label>
						<form:select path="type" class="form-select">
							<c:forEach items="${typeAntecedents}" var="type">
								<form:option value="${type}">${type}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<div class="mb-3">
						<form:label path="title">T�tulo:</form:label>
						<form:input path="title" class="form-control" />
						<form:errors path="title" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="description">Descripci�n y observaciones:</form:label>
						<form:textarea path="description" class="form-control" />
						<form:errors path="description" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="studyDate">Fecha de detecci�n:</form:label>
						<form:input path="studyDate" class="form-control" type="date" />
						<form:errors path="studyDate" class="text-danger" />
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-success" value="A�adir">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>