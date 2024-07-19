<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		
		<form action="">
		
			<select>
				<c:forEach items ="${ provinciasResp.provincias }" var="provincia">
					<option>${ provincia.nombre }</option>
				</c:forEach>
			</select>
		
		</form>
		
	</div>


</body>
</html>