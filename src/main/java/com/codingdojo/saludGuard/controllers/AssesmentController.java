package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AssesmentController {

	@Autowired
	private DoctorService docServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private PatientService patServ;
	
	@GetMapping("/findPatient")
	public String findPatientAsses(HttpSession session) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		return "formDniPatient.jsp";
	}
	
	@PostMapping("/getPatient")
	public String getPatientAsses(@RequestParam("dniPaciente") String dniPaciente,
							HttpSession session, RedirectAttributes redirectAttributes) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		User user = userServ.getUserByUserDNI(dniPaciente);
		Patient patient = patServ.getPatientByUser(user);
		
		if(patient == null) {
			redirectAttributes.addFlashAttribute("errorFind", "patient does not exist");
			return "redirect:/findPatient";
		}
		
		session.setAttribute("patientTemp", patient);
		return "redirect:/dashboard/doctor";
	}
	
	@GetMapping("/dashboard/doctor")
	public String dashboardDoctor(HttpSession session) {
		
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		return "dashboard_d.jsp";
	}
}
