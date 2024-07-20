<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>physical detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>physical detail</h2>
				<form:form action="/physical" method="POST" modelAttribute="physicalDetail" >
					<div>
						<form:label path="bloodPressure" >blood Pressure</form:label>
						<form:input path="bloodPressure" class="form-control" />
						<form:errors path="bloodPressure" class="text-danger" />
					</div>
					<div>
						<form:label path="heartRate" >heart Rate:</form:label>
						<form:input path="heartRate" class="form-control" />
						<form:errors path="heartRate" class="text-danger" />
					</div>
					<div>
						<form:label path="bodyState" >body State:</form:label>
						<form:input path="bodyState" class="form-control" />
						<form:errors path="bodyState" class="text-danger" />
					</div>
					<div>
						<form:label path="observ">observ:</form:label>
   						<form:textarea path="observ" class="form-control" />
    					<form:errors path="observ" class="text-danger" />
					</div>
					
					<input type="submit" class="btn btn-success" value="Add" >
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>