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
        background: url('../img/histo.png') no-repeat center center;
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
<body>
    <div class="image-section"></div>
    <div class="form-section">
        <div class="form-container">
            <h2 class="text-center">Medical Antecedent</h2>
            <form:form action="/antecedent/save" method="POST" modelAttribute="antecedent">
                <div class="mb-3">
                    <form:label path="type">Type:</form:label>
                    <form:select path="type" class="form-select">
                        <c:forEach items="${typeAntecedents}" var="type">
                            <form:option value="${type}">${type}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="mb-3">
                    <form:label path="title">Title:</form:label>
                    <form:input path="title" class="form-control" />
                    <form:errors path="title" class="text-danger" />
                </div>
                <div class="mb-3">
                    <form:label path="description">Description:</form:label>
                    <form:textarea path="description" class="form-control" />
                    <form:errors path="description" class="text-danger" />
                </div>
                <div class="mb-3">
                    <form:label path="studyDate">Study Date:</form:label>
                    <form:input path="studyDate" class="form-control" type="date" />
                    <form:errors path="studyDate" class="text-danger" />
                </div>
                <div class="text-center">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>