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
        margin: 0;
        height: 700px; 
        display: flex;
        flex-direction: row;
        overflow: hidden; 
    }
    .image-section {
        flex: 1.5; 
        background: url('../img/fisico.png') no-repeat center center;
        background-size: cover;
        height: 700px; 
    }
    .form-section {
        flex: 1; 
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: rgb(234, 234, 234);
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
  
	.form-container .btn {
    	margin-top: 20px; 
	}
</style>
</head>
<body>
	<div class="image-section"></div>
    <div class="form-section">
				<div class="form-container">
				<h2  class="text-center">Physical Detail</h2>
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

</body>
</html>