package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.saludGuard.models.PhysicalDetail;
import com.codingdojo.saludGuard.services.PhysicalDetailService;

import jakarta.validation.Valid;

@Controller
public class PhysicalController {
	
	@Autowired
	private PhysicalDetailService  psd;
	
	@GetMapping("/physical")
    public String showPhysicalDetail(@ModelAttribute("physicalDetail") PhysicalDetail physicalDetail) {
        return "physical.jsp";
    }

    @PostMapping("/physical")
    public String createPhysicalDetail(@Valid @ModelAttribute("physicalDetail") PhysicalDetail physicalDetail,
                                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "physical.jsp";
        }
        //Calculamos el IMC 
        
        float height = physicalDetail.getHeight(); //estatura
        float weight = physicalDetail.getWeight(); //peso
        //IMC = peso(KG) / [estatura (m)] ** 2;
        float patientIMC = weight / (float) Math.pow(height, 2);
        
        physicalDetail.setPatientIMC(patientIMC);
        
        psd.savePhysicalDetail(physicalDetail);
        return "redirect:/prueba"; // agrege prueba solo para probar si funciona pero cambiar despues
    }
	

}