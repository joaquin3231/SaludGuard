<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Antecedent </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Medical Antecedent</h2>
				<form:form action="/antecedent/save" method="POST" modelAttribute="antecedent" >
					<div>
						<form:label path="type" >type:</form:label>
						<form:select path="type">
							<c:forEach items="${typeAntecedents}" var="type">
								<form:option value="${type}">${type}</form:option>
							</c:forEach>
						</form:select>
					</div>					
					<div>
						<form:label path="title" > title:</form:label>
						<form:input path="title" class="form-control" />
						<form:errors path="title" class="text-danger" />
					</div>
					<div>
						<form:label path="description">description:</form:label>
   						<form:textarea path="description" class="form-control" />
    					<form:errors path="description" class="text-danger" />
					</div>
					<div>
						<form:label path="studyDate" >study Date:</form:label>
						<form:input path="studyDate" class="form-control" type="date"/>
						<form:errors path="studyDate" class="text-danger" />
					</div>
					
					<input type="submit" class="btn btn-success" value="Add" >
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>