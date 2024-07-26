<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Treatment</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
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
        background-color: rgb(31 152 111);
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
        
    }
    .image-section {
        flex: 1.5; 
        background: url('../img/tratamient.png') no-repeat center center;
        background-size: cover;
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
        min-height: 450px; 
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
    <div class="header">
        <img src="../img/logosaludguardwhite.png" alt="Logo">
    </div>
    <div class="content">
        <div class="image-section"></div>
        <div class="form-section">
            <div class="form-container">
                <h2 class="text-center"> Treatment</h2>
                <form:form action="/treatment/save" method="POST" modelAttribute="treatmentNew">
                    <div class="mb-3">
                        <form:label path="type">Type:</form:label>
                        <form:input path="type" class="form-control" />
                        <form:errors path="type" class="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="description">Description:</form:label>
                        <form:textarea path="description" class="form-control" />
                        <form:errors path="description" class="text-danger" />
                    </div>
                    <div class="text-center">
                        <input type="submit" class="btn btn-success" value="Add">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>