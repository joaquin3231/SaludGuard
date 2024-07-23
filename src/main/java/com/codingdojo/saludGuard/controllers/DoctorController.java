package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.saludGuard.models.Admin;
import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Gender;
import com.codingdojo.saludGuard.models.Location;
import com.codingdojo.saludGuard.models.MedicalRecord;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/register/prof")
	public String registerDoctor(@ModelAttribute("newUser") User newUser, Model model, HttpSession session) {
		
		/*=== REVISION DE SESION ===*/
		Admin adminTemp = (Admin) session.getAttribute("adminInSession"); //Obj User or Null
		
		if(adminTemp == null) {
			
			return "redirect:/home";
		}
		
		if(adminTemp.getId().equals(null)) {
			
			return "redirect:/home";
		}
		/*=== REVISION DE SESION ===*/
		
		model.addAttribute("genders", Gender.Genders);
		
		return "register_d.jsp";
		
	}
	
	@PostMapping("/register/prof")
	public String registerDoctor(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		
		userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("genders", Gender.Genders); //Enviar la lista de generos
			return "register_d.jsp";
		} else {
			
			userServ.saveUser(newUser);
			
			session.setAttribute("userDoctor", newUser);
			
			return "redirect:/prof/location";
		}
		
	}
	
	@GetMapping("/register/prof/confirmation")
	public String confirmDoctor(Model model, HttpSession session) {
		/*=== REVISION DE SESION ===*/
		User doctorTemp = (User) session.getAttribute("userDoctor"); //Obj User or Null
		
		if(doctorTemp == null) {
			
			return "redirect:/home";
		}
		/*=== REVISION DE SESION ===*/
		return "confirm_reg_d.jsp";
	}
	
	@PostMapping("/register/prof/confirmation/save")
	public String confirmDoctor(@RequestParam("medLicense") String medLicense, Model model, HttpSession session) {
		User doctorTemp = (User) session.getAttribute("userDoctor"); //Obj User or Null
		
		if(doctorTemp == null) {
			
			return "redirect:/home";
		}
		/*=== REVISION DE SESION ===*/
			
		Doctor newDoctor = new Doctor();
		newDoctor.setUser(doctorTemp);
		newDoctor.setMedLicense(medLicense);
		doctorService.saveDoctor(newDoctor);

		return "redirect:/admin/centraldashboard";
	
	}
	
	
}
