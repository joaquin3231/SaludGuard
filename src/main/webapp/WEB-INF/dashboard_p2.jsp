<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Panel para pacientes</title>
    <link rel="stylesheet" href="../css/styledashboard_p.css">
    <link rel="stylesheet" href="../css/patientDashboard.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="radio-canada-big-body">
    <div>
        <nav class="navbar navbar-custom navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img id="logo1" src="../img/logosaludguardwhite.png" width="200" alt="Logo">
					<span class="ms-2"> | Panel del paciente</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a id="logout" class="btn btn-custom" href="/logout">Cerrar sesion</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="cotenedor mt-5">
        	
        	<div class="izq">
        		<div class="sup">
        			<div class="divNav">
        				<img alt="flechitas" src="../img/patientImg/flechitas.png">
        				<p>Detalles Fisicos</p>
        			</div>
        			  			
        			<div class="content">
        			 	<img src="../img/patientImg/sticman.png" alt="patient sticman">
        			 	
        			 	<c:if test="${ physicalDetail != null }">
        			 		<div class="contIzq">
	        					<p>Altura (M): <br>
	        					${ physicalDetail.height }</p>
	        					<p>Peso (Kg): <br>
	        					${ physicalDetail.weight }</p>
	        					<p>I.M.C <br>
	        					${ physicalDetail.patientIMC }</p>
	        				</div>
	        				<div class="contDer">
	        					<p>Presion Arterial <br>
	        					${ physicalDetail.bloodPressure }</p>
	        					<p>Ritmo Cardiaco <br>
	        					${ physicalDetail.heartRate }</p>
	        				</div>
        			 	</c:if>
        			 	
        			 	<c:if test="${ physicalDetail == null }">
        			 		<div class="contIzq">
	        					<p>Altura (M): <br>
	        					NO REGISTRADO</p>
	        					<p>Peso (Kg): <br>
	        					NO REGISTRADO</p>
	        					<p>I.M.C <br>
	        					NO REGISTRADO</p>
	        				</div>
	        				<div class="contDer">
	        					<p>Presion Arterial <br>
	        					NO REGISTRADO</p>
	        					<p>Ritmo Cardiaco <br>
	        					NO REGISTRADO</p>
	        				</div>
        			 	</c:if>
        			</div>
                    
                </div>
        		<div class="inf">
        			<div class="divNav">
        				<img alt="historial" src="../img/patientImg/historial.png">
        				<p>Historia de Consultas</p>
        			</div>   
        			
        			<div>
        			 <!-- Formulario para los filtros -->
				<form id="filterForm" method="GET" action="/dashboard/${patient.id}">
				    <label for="doctorFirstName">Nombre del Doctor:</label>
				    <input type="text" id="doctorFirstName" name="doctorFirstName" value="${param.doctorFirstName}">
				    <br>
				    <label for="date">Fecha:</label>
				    <input type="date" id="date" name="createAt" value="${param.createAt}">
				    <br>
				    <button type="submit">Aplicar Filtro</button>
				</form>
				<br>
				
				<table class="table table-striped">
				    <thead>
				        <tr>
				            <th><i class="fas fa-calendar-alt fa-sm"></i> Fecha de consulta</th>
				            <th><i class="fas fa-user-md fa-sm"></i> Profesional</th>
				            <th><i class="fas fa-sticky-note fa-sm"></i> Observaciones</th>
				            <th><i class="fas fa-info-circle fa-sm"></i> Más información</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach items="${assesmentList}" var="assesment">
				            <tr>
				                <td>${assesment.createAt}</td>
				                <td>${assesment.doctor.user.firstName}</td>
				                <td>${assesment.observation}</td>
				                <td><a href="#">Más información</a></td>
				            </tr>
				        </c:forEach>
				    </tbody>
				</table>

        			</div>
        			     			<!-- Formulario para los filtros 
=======
        				<c:if test="${ assesmentList.size() != 0 }">
	        				<table class="table table-striped">
								<thead>
	                                <tr>
									<th><i class="fas fa-calendar-alt fa-sm"></i> Fecha de consulta</th>
									<th><i class="fas fa-user-md fa-sm"></i> Profesional</th>
									<th><i class="fas fa-sticky-note fa-sm"></i> Observaciones</th>
									<th><i class="fas fa-info-circle fa-sm"></i> Mï¿½s informaciï¿½n</th>
	                        	</tr>
							</thead>
	                    		<tbody>
									<c:forEach items="${assesmentList}" var="assesment">
										<tr>
											<td>${assesment.createAt}</td>
											<td>${assesment.doctor.user.firstName}</td>
											<td>${assesment.observation}</td>
											<td> <a href="#">Mas informacion</a> </td>
										</tr>
									</c:forEach>
	                        	</tbody>
	                     	</table>
        				</c:if>
        				
        				<c:if test="${ assesmentList.size() == 0 }">
        					<div class="content">
        					    <div class="carga" id="consulta">
	        						<p>Ninguna consulta cargado</p>
	        					</div>
        					</div>
        				</c:if>
        				

        			</div>			
>>>>>>> branch 'master' of https://github.com/joaquin3231/SaludGuard.git*/-->
        		</div>
        	</div>
        	
        	<div class="der">
        		<div class="sup">
        			<div class="divNav">
        				<img alt="medicinas" src="../img/patientImg/medicamento.png">
        				<p>Tratamientos</p>
        			</div>
        			
        			<div class="content">
        			
        				<c:if test="${ treatment == null }">
        					<div class="carga" id="tratamiento">
	        					<p>Ningun tratamiento cargado</p>
	        				</div>
        				</c:if>
        			
        				<c:if test="${ treatment != null }">
   							<p class="tipo"> <b>Tipo: </b> <span>${ treatment.type }</span> </p>
	        				<p class="description"> <b>Descripcion: </b> <br>
							<span>${ treatment.description }</span></p>
        				</c:if>
        			

        			</div>
        		</div>
        		<div class="inf">
        			<div class="divNav">
        				<img alt="antecedentes" src="../img/patientImg/antecedente.png">
        				<p>Antecedentes Medicos</p>
        			</div>
        			
        			<div class="content">
        			
        				<c:if test="${ antecedentDate == null }">
	        				<div class="carga" id="antecedentes">
	        					<p>Ningun antecedente medico cargado</p>
	        				</div>
        				</c:if>
        				
        				<c:if test="${ antecedentDate != null }">
        					<p>Fecha de Estudio:  <br>
	       					${ antecedentDate }</p>
	       					<p>Tipo: <br>
	       					${ antecedent.type }</p>
	       					<p>Titulo: <br>
	       					${ antecedent.title }</p>
	       					<p>Descripcion <br>
	       					${ antecedent.description }</p>
        				</c:if>
        			</div>
        			
        		</div>
        	</div>
        
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>