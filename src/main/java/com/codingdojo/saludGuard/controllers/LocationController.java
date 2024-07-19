package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.codingdojo.saludGuard.models.Location;
import com.codingdojo.saludGuard.services.LocationService;

import jakarta.validation.Valid;

@Controller
public class LocationController {

	@Autowired
	private LocationService locServ;
	
	@GetMapping("/location")
	public String formLocation(	@ModelAttribute("location") Location location,
								Model model) {
		
		
		String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
		RestTemplate restTemplateProv = new RestTemplate();
		Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
		model.addAttribute("provinciasResp", respuestaProv);
		
		return "FormLocations.jsp";
	}
	
	@PostMapping("/location/save")
	public String saveLocation(	@Valid @ModelAttribute("location") Location location,
								BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
			RestTemplate restTemplateProv = new RestTemplate();
			Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
			model.addAttribute("provinciasResp", respuestaProv);
			
			return "FormLocations.jsp";
		} else {
			locServ.saveLocation(location);
			return "redirect:/location";
		}
	}
}
