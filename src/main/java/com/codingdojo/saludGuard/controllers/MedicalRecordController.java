package com.codingdojo.saludGuard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.User;
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
	
	@GetMapping("/dashboard/{patientId}")
	public String dashboard(@PathVariable("patientId") Long patientId, HttpSession session, Model model) {
		
		/* === REVISAMOS SESION === */
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/inicioSesion";
		}
		/* === REVISAMOS SESION === */
		
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
		
		if(userTemp.getLocation() == null) {
			return "redirect:/location";
		}
		
		return "dashboard_p.jsp";
		
	}
}
