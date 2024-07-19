package com.codingdojo.saludGuard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.codingdojo.saludGuard.models.Location;



@Controller
public class LocationController {

	@GetMapping("/location")
	public String formLocation(	@ModelAttribute("location") Location location,
								Model model) {
		
		
		String urlProvincias = "https://apis.datos.gob.ar/georef/api/provincias";
		RestTemplate restTemplateProv = new RestTemplate();
		Object respuestaProv = restTemplateProv.getForObject(urlProvincias, Object.class);
		model.addAttribute("provinciasResp", respuestaProv);


		
		String urlMunicipios = "https://apis.datos.gob.ar/georef/api/municipios";
		RestTemplate restTemplateMun = new RestTemplate();
		Object respuestaMun = restTemplateMun.getForObject(urlMunicipios, Object.class);
		model.addAttribute("municipos", respuestaMun);
		
		
		return "FormLocations.jsp";
	}
	
}
