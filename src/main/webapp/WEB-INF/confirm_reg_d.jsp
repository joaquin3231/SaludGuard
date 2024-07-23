<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Confirmación</title>
</head>
<body>
	<div class="container">
		<form:form action="/register/prof/confirmation" method="POST" modelAttribute="medLicense" class="row g-3" id="formLocation">
				
			<div class="col-12">
				<form:label path="medLicense">Matrícula:</form:label>
				<form:input path="medLicense" class="form-control" id="address"/>
				<form:errors path="medLicense" class="text-danger"/>
			</div>
					
			<input type="hidden" value="${userInSession.id}" id="user">
					
			<div class="col-12">
				<input type="submit" class="btn btn-dark mt-3" value="Registrar" >
			</div>
		</form:form>
	</div>
</body>
</html>