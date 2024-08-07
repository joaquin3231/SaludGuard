package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Gender;
import com.codingdojo.saludGuard.models.MedicalRecord;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private PatientService patServ;
	
	@Autowired
	private DoctorService docServ;
	
	@Autowired
	private MedicalRecordService mrServ;
	
	@GetMapping("/home")
	public String landingPage() {
		
		return "landingpage.jsp";
	}
	
	@GetMapping("/")
	public String registrarUser(@ModelAttribute("newUser") User newUser,
			Model model) {
		
		model.addAttribute("genders", Gender.Genders); 
		
		return "register_p.jsp";
	}
	
	@GetMapping("/inicioSesion")
	public String inicioSesion() {
		
		return "access_p.jsp";
	}
	
	@GetMapping("/inicioSesion/doc")
	public String inicioSesionDoctor() {
		
		return "access_d.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("genders", Gender.Genders);
			return "register_p.jsp";
		} else {
			
			userServ.saveUser(newUser);
			Patient newPatient = new Patient();
			MedicalRecord newMedicalRecord = new MedicalRecord();
			newPatient.setUser(newUser);
			newPatient.setMedicalRecord(newMedicalRecord);
			patServ.savePatient(newPatient);
			mrServ.saveMedicalRecord(newMedicalRecord);
			
			session.setAttribute("userInSession", newUser);
			return "redirect:/location";
		}
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes,
						HttpSession session){
		
		User userTryingLogin = userServ.login(email, password);
		
		if(userTryingLogin == null) {

			redirectAttributes.addFlashAttribute("errorLogin", "Wrong email/password");
			return "redirect:/inicioSesion";
		} else {
			
			session.setAttribute("userInSession", userTryingLogin);
			Long patientId = patServ.getPatientByUser(userTryingLogin).getId();
			
			return "redirect:/dashboard/"+patientId;
		}
		
	}
	
	@PostMapping("/loginDoc")
	public String loginDoc(@RequestParam("userDNI") String userDNI,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes, /*flash messages*/   
						HttpSession session){
		
		User userTryingLogin = userServ.loginByDni(userDNI, password);
		
		if(userTryingLogin == null) {
			
			redirectAttributes.addFlashAttribute("errorLogin", "Wrong dni/password");
			return "redirect:/inicioSesion/doc";
		} else {
			
			Doctor doctTemp = docServ.getDoctorByUser(userTryingLogin);
			
			
			session.setAttribute("doctTemp", doctTemp);
			return "redirect:/findPatient";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("userInSession");
		session.removeAttribute("adminInSession");
		return "redirect:/";
	}
	
}
