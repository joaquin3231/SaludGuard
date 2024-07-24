<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Physical Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style>
    body {
        background-image: url("../img/login_pac.png"); /* Ruta de la imagen de fondo */
        background-size: cover;
        background-position: center;
        height: 500px;
    }
    .form-container {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 30px;
        margin: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 700px;
    }
</style>

</head>
<body>
	<div class="container  d-flex justify-content-center align-items-center"  style="height: 600px;">
		<div class="row w-100">
			<div class="col-12 d-flex justify-content-center">
				<div class="form-container">
				<h2  class="text-center">physical detail</h2>
				<form:form action="/physical" method="POST" modelAttribute="physicalDetail" >
					<div class="mb-3">
						<form:label path="bloodPressure" >blood Pressure</form:label>
						<form:input path="bloodPressure" class="form-control" />
						<form:errors path="bloodPressure" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="height" >Height in meters</form:label>
						<form:input path="height" class="form-control" />
						<form:errors path="height" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="weight" >Weight in KL</form:label>
						<form:input path="weight" class="form-control" />
						<form:errors path="weight" class="text-danger" />
					</div >
					<div>
						<form:label path="heartRate" >heart Rate:</form:label>
						<form:input path="heartRate" class="form-control" />
						<form:errors path="heartRate" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="bodyState" >body State:</form:label>
						<form:input path="bodyState" class="form-control" />
						<form:errors path="bodyState" class="text-danger" />
					</div>
					<div class="mb-3">
						<form:label path="observ">observ:</form:label>
   						<form:textarea path="observ" class="form-control" />
    					<form:errors path="observ" class="text-danger" />
					</div>
					 <div class="text-center">
					<input type="submit" class="btn btn-success" value="Add" >
					</div>
				</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>