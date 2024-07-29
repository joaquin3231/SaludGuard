<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Panel para doctores</title>
    <link rel="stylesheet" href="../css/styledashboard_p.css">
    <link rel="stylesheet" href="../css/doctorDashboard.css">
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
					<span class="ms-2"> |   Panel del profesional   |   Paciente: ${antecedentTemp.patient.user.firstName} ${antecedentTemp.patient.user.lastName} </span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                        	<span class="doctorData">${doctTemp.user.lastName}, ${doctTemp.user.firstName} | MM.NN: ${doctTemp.medLicense}       </span>
                            <a id="logout" class="btn btn-custom" href="/logout">Cerrar sesión</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="cotenedor mt-5">
        	
        	<div class="izq">
        		<div class="sup">
        			<div class="divNav">
        				<div>
	        				<img alt="flechitas" src="../img/patientImg/flechitas.png">
	        				<p>Detalles Físicos</p>	
        				</div>

        				<a href="/physical">Editar detalles fisicos</a> <br>
        			</div>
        			  			
        			<div class="content">
        			 	<img src="../img/patientImg/sticman.png" alt="patient sticman">
        			 	
        			 	<c:if test="${ physicalDetail != null }">
        			 		<div class="contIzq">
	        					<p>Altura (en m):<br>
	        					${ physicalDetail.height }</p>
	        					<p>Peso (en Kg):<br>
	        					${ physicalDetail.weight }</p>
	        					<p>I.M.C (Índice de masa corporal):<br>
	        					${ physicalDetail.patientIMC }</p>
	        				</div>
	        				<div class="contDer">
	        					<p>Presión Arterial (en mmHg):<br>
	        					${ physicalDetail.bloodPressure }</p>
	        					<p>Ritmo Cardíaco (en ppm máx.):<br>
	        					${ physicalDetail.heartRate }</p>
	        				</div>
        			 	</c:if>
        			 	
        			 	<c:if test="${ physicalDetail == null }">
        			 		<div class="contIzq">
	        					<p>Altura (en m):<br>
	        					NO REGISTRADO</p>
	        					<p>Peso (en Kg):<br>
	        					NO REGISTRADO</p>
	        					<p>I.M.C (Índice de masa corporal):<br>
	        					NO REGISTRADO</p>
	        				</div>
	        				<div class="contDer">
	        					<p>Presión Arterial (en mmHg):<br>
	        					NO REGISTRADO</p>
	        					<p>Ritmo Cardíaco (en ppm máx.):<br>
	        					NO REGISTRADO</p>
	        				</div>
        			 	</c:if>
        			</div>
                    
                </div>
        		<div class="inf">
        			<div class="divNav">
        				<div>
        					<img alt="historial" src="../img/patientImg/historial.png">
        					<p>Historia de Consultas</p>
        				</div>
        				
        				<a href="/existConsult" class="finalizar">Finalizar Consulta</a>
        			</div>   
        			
        			<div>
        			
        				<c:if test="${ assesmentList.size() != 0 }">
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
											<td>${assesment.doctor.user.firstName} ${assesment.doctor.user.lastName}</td>
											<td>${assesment.observation}</td>
											<td> <a href="#">Mas información</a> </td>
										</tr>
									</c:forEach>
	                        	</tbody>
	                     	</table>
        				</c:if>
        				
        				<c:if test="${ assesmentList.size() == 0 }">
        					<div class="content">
        					    <div class="carga" id="consulta">
	        						<p>No se encuentran consultas registradas</p>
	        					</div>
        					</div>
        				</c:if>
        				

        			</div>			
        		</div>
        	</div>
        	
        	<div class="der">
        		<div class="sup">
        			<div class="divNav">
        				<div>
	        				<img alt="medicinas" src="../img/patientImg/medicamento.png">
	        				<p>Tratamientos</p>
        				</div>
        				
        				<a href="/treatment">Cargar nuevo tratamiento</a> <br>
        			</div>
        			
        			<div class="content">
        			
        				<c:if test="${ treatment == null }">
        					<div class="carga" id="tratamiento">
	        					<p>No se encuentran tratamientos registrados</p>
	        				</div>
        				</c:if>
        			
        				<c:if test="${ treatment != null }">
   							<p class="ml-2 tipo"> <b>       Tipo: </b> <span>${ treatment.type }</span> </p>
	        				<p class="ml-2 description"> <b>       Descripción: </b> <br>
							<span>       ${ treatment.description }</span></p>
        				</c:if>
        			

        			</div>
        		</div>
        		<div class="inf">
        			<div class="divNav">
        				<div>
	        				<img alt="antecedentes" src="../img/patientImg/antecedente.png">
	        				<p>Antecedentes médicos</p>
        				</div>
        				
        				<a href="/antecedent">Cargar nuevo antecedente</a> <br>
        			</div>
        			
        			<div class="content">
        			
        				<c:if test="${ antecedentDate == null }">
	        				<div class="carga" id="antecedentes">
	        					<p>No se encuentran antecedentes médicos registrados</p>
	        				</div>
        				</c:if>
        				
        				<c:if test="${ antecedentDate != null }">
        					<p>Fecha de Estudio:  <br>
	       					${ antecedentDate }</p>
	       					<p>Tipo: <br>
	       					${ antecedent.type }</p>
	       					<p>Título: <br>
	       					${ antecedent.title }</p>
	       					<p>Descripción <br>
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