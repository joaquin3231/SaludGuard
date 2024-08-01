package com.codingdojo.saludGuard.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.MedicalAntecedent;
import com.codingdojo.saludGuard.models.MedicalRecord;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.PhysicalDetail;
import com.codingdojo.saludGuard.models.Treatment;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.AssesmentService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MedicalRecordController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private PatientService patServ;
	
	@Autowired
	private MedicalRecordService mrServ;
	
	@Autowired
	private AssesmentService asseServ;
	
	@GetMapping("/dashboard/{patientId}")
	public String dashboard(@PathVariable("patientId") Long patientId, 
			@RequestParam(value = "doctorFirstName", required = false) String doctorFirstName,
	        @RequestParam(value = "createAt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date createAt,
			HttpSession session, Model model) {
		
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/inicioSesion";
		}
		/* === REVISAMOS SESION === */
		
		if(userTemp.getLocation() == null) {
			return "redirect:/location";
		}
		
		//Enviar mi paciente
		Patient myPatient = patServ.getPatient(patientId);
		model.addAttribute("patient", myPatient);
		
		
		// FILTRADO
	    List<Asessment> filteredAssessments;

	    if (doctorFirstName != null && !doctorFirstName.isEmpty() && createAt != null) {
	        filteredAssessments = asseServ.getAsessmentsByDoctorFirstNameAndDate(doctorFirstName, createAt);
	    } else if (doctorFirstName != null && !doctorFirstName.isEmpty()) {
	        filteredAssessments = asseServ.getAsessmentsByDoctorFirstName(doctorFirstName);
	    } else if (createAt != null ) {
	        filteredAssessments = asseServ.getAsessmentsByDateIgnoringTime(createAt);
	    } else {
	        filteredAssessments = myPatient.getMedicalRecord().getAssementList(); 
	    }
	    
	    model.addAttribute("assesmentList", filteredAssessments);
		//CONSULTAS
		//Obtener la lista de consultas del historial clinico del paciente

		
		//Obtenemos Las ultimas tres consultas
		/*List<Asessment> aseesmentList = new ArrayList<>();
<<<<<<< HEAD
		
		for (int i = (patientAssesments.size() - 1);i >= patientAssesments.size() - 6; i-- ) {
			aseesmentList.add(patientAssesments.get(i));
		}*/
		
		/*List<Asessment> patientAssesments = myPatient.getMedicalRecord().getAssementList();
		/*
		model.addAttribute("assesmentList", patientAssesments);

		for (int i = (patientAssesments.size() - 1);i >= patientAssesments.size() - 6; i-- ) {
			if(i < 0) {
				break;
			} else {
				aseesmentList.add(patientAssesments.get(i));
			}
		}
		model.addAttribute("assesmentList", aseesmentList);
 branch 'master' of https://github.com/joaquin3231/SaludGuard.git
		*/
		//DETALLES FISICOS
		//Obtenemos toda la historia clinica
		MedicalRecord medicalRecord = myPatient.getMedicalRecord();
		
		//Obtenemos la lista de detalles fisico
		List<PhysicalDetail> physicalList = medicalRecord.getPhysicalDetailList();
		
		//Obtenemos el ultimo detalle fisico
		
		if(physicalList.size() != 0) {
			PhysicalDetail physicalDetail = physicalList.get(physicalList.size() - 1);
			model.addAttribute("physicalDetail", physicalDetail);
		}
		
		//TRATAMIENTOS
		//Obtenemos la lista de tratamientos
		List<Treatment> treatmentList = medicalRecord.getTreatmentList();
		
		//Obtenemos el ultimo tratamiento hecho
		
		if(treatmentList.size() != 0) {
			Treatment treatment = treatmentList.get(treatmentList.size() - 1);
			model.addAttribute("treatment", treatment);			
		}
		
		//ANTECEDENTES MEDICOS
		List<MedicalAntecedent> antecedentList = medicalRecord.getMedicalAntecedentsList();
		
		//Obtenemos el ultimo antecedente hecho
		if(antecedentList.size() != 0) {
			MedicalAntecedent antecedent = antecedentList.get(antecedentList.size() - 1);
			
			SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatFecha.format(antecedent.getStudyDate());
			
			model.addAttribute("antecedentDate", fecha);
			model.addAttribute("antecedent", antecedent);
		}

		
		//Medida de seguridad extra
		Long patientInSessionId = patServ.getPatientByUser(userTemp).getId();
		if(patientInSessionId != patientId) {
			return "redirect:/dashboard/"+patientInSessionId;
		}
		
		return "dashboard_p2.jsp";
		
	}
	
	
	
	@GetMapping("/dashboard/table/{patientId}")
	public String dashboard(@PathVariable("patientId") Long patientId, HttpSession session, Model model) {
		
		// === REVISAMOS SESION ===
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/inicioSesion";
		}
		// === REVISAMOS SESION ===
		
		if(userTemp.getLocation() == null) {
			return "redirect:/location";
		}
		
		//Enviar mi paciente
		Patient myPatient = patServ.getPatient(patientId);
		model.addAttribute("patient", myPatient);
		
		//Obtener la lista de consultas del historial clinico del paciente
		List<Asessment> patientAssesments = myPatient.getMedicalRecord().getAssementList();
		model.addAttribute("assesmentList", patientAssesments);
		
		//Medida de seguridad extra
		Long patientInSessionId = patServ.getPatientByUser(userTemp).getId();
		if(patientInSessionId != patientId) {
			return "redirect:/dashboard/"+patientInSessionId;
		}
		
		return "dashboard_p.jsp";
		
	}
	
	
}
