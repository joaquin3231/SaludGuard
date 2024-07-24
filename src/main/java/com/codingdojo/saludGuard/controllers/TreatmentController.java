package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Treatment;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.TreatmentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class TreatmentController {

	@Autowired
	private TreatmentService treatServ;
	
	@Autowired
	private DoctorService docServ;
	
	@GetMapping("/treatment")
	public String treatmentForm(@ModelAttribute("treatmentNew") Treatment treatment,
								HttpSession session) {
		/*=== REVISION DE SESION ===*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User or Null
		
		Doctor docTemp = docServ.getDoctorByUser(userTemp);
		if(docTemp == null) {
			
			return "redirect:/";
		}
		/*=== REVISION DE SESION ===*/
		
		
		return "treatment.jsp";
	}
	
	@PostMapping("/treatment/save")
	public String treatmentFormSave(@Valid @ModelAttribute("treatmentNew") Treatment treatment,
									HttpSession session, BindingResult result) {
		
		/*=== REVISION DE SESION ===*/
		User userTemp = (User) session.getAttribute("userInSession"); //Obj User or Null
		
		Doctor docTemp = docServ.getDoctorByUser(userTemp);
		if(docTemp == null) {
			
			return "redirect:/";
		}
		/*=== REVISION DE SESION ===*/
		
		if(result.hasErrors()) {
			return "treatment.jsp";
		} else {
			
			treatServ.saveTreatment(treatment);
			
			return "redirect:/admin/centraldashboard";
		}
	}
	
	
}
