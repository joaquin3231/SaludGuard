package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.codingdojo.saludGuard.models.Admin;
import com.codingdojo.saludGuard.models.Location;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.LocationService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LocationController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private LocationService locServ;
	
	@Autowired
	private PatientService patServ;
	
	@Autowired
	private MedicalRecordService mrServ;
	
	@Autowired
	private LocationService locationServ;
	
	@GetMapping("/location")
	public String formLocation(	@ModelAttribute("location") Location location,
								Model model, HttpSession session) {

		User userTemp = (User) session.getAttribute("userInSession");
		
		if(userTemp == null) {
			
			return "redirect:/";
		}
		
		String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
		RestTemplate restTemplateProv = new RestTemplate();
		Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
		model.addAttribute("provinciasResp", respuestaProv);
		
		return "FormLocations.jsp";
	}
	
	@PostMapping("/location/save")
	public String saveLocation(	@Valid @ModelAttribute("location") Location location,
								BindingResult result, Model model, HttpSession session) {
		
		User userTemp = (User) session.getAttribute("userInSession");
		
		if(userTemp == null) {
			
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
			RestTemplate restTemplateProv = new RestTemplate();
			Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
			model.addAttribute("provinciasResp", respuestaProv);
			
			return "FormLocations.jsp";
			
		} else {
			userTemp.setLocation(location);
			userServ.saveUser(userTemp);
			
			Long patientId = patServ.getPatientByUser(userTemp).getId();
			return "redirect:/dashboard/"+patientId;
		}
	}
	
	@GetMapping("/prof/location")
	public String formLocationProf(	@ModelAttribute("location") Location location,
								Model model, HttpSession session) {

		Admin adminTemp = (Admin) session.getAttribute("adminInSession");
		
		if(adminTemp == null) {
			
			return "redirect:/home";
		}
		
		if(adminTemp.getId().equals(null)) {
			
			return "redirect:/home";
		}
		
		User doctorTemp = (User) session.getAttribute("userDoctor");
		
		String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
		RestTemplate restTemplateProv = new RestTemplate();
		Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
		model.addAttribute("provinciasResp", respuestaProv);
		
		model.addAttribute("idDoctor", doctorTemp.getId()); //para JS
		
		return "FormLocations_d.jsp";
	}
	
	@PostMapping("/profLocation/save")
	public String saveLocationProf(	@Valid @ModelAttribute("location") Location location,
								BindingResult result, Model model, HttpSession session) {
		
		Admin adminTemp = (Admin) session.getAttribute("adminInSession");
		
		if(adminTemp == null) {
			
			return "redirect:/home";
		}
		
		if(adminTemp.getId().equals(null)) {
			
			return "redirect:/home";
		}
		
		if(result.hasErrors()) {
			
			String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
			RestTemplate restTemplateProv = new RestTemplate();
			Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
			model.addAttribute("provinciasResp", respuestaProv);
			
			return "FormLocations_d.jsp";
			
		} else {
			User doctorTemp = (User) session.getAttribute("userDoctor");
			
			doctorTemp.setLocation(location);
			
			session.setAttribute("userDoctor", doctorTemp);
			
			return "redirect:/register/prof/confirmation";
		}
	}
}
