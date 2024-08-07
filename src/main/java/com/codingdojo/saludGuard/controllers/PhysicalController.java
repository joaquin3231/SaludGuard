package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.PhysicalDetail;
import com.codingdojo.saludGuard.services.AssesmentService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.PhysicalDetailService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PhysicalController {
	
	@Autowired
	private PhysicalDetailService psd;
	
	@Autowired
	private AssesmentService asessServ;
	
	@Autowired
	private MedicalRecordService medicRecServ;
	
	@Autowired
	private PatientService patServ;
	
	@GetMapping("/physical")
    public String showPhysicalDetail(@ModelAttribute("physicalDetail") PhysicalDetail physicalDetail, HttpSession session) {
		
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		
        return "physical.jsp";
    }

    @PostMapping("/physical")
    public String createPhysicalDetail(@Valid @ModelAttribute("physicalDetail") PhysicalDetail physicalDetail,
                                       BindingResult result, Model model, HttpSession session) {
    	
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp");
		
		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
    	
        if (result.hasErrors()) {
            return "physical.jsp";
        }
        
        float height = physicalDetail.getHeight();
        float weight = physicalDetail.getWeight();
        float patientIMC = weight / (float) Math.pow(height, 2);
        
        physicalDetail.setPatientIMC(patientIMC);
        
		Asessment asessTemp = (Asessment) session.getAttribute("antecedentTemp");
		Patient patientTemp = (Patient) session.getAttribute("patientTemp");
        
		Asessment asessment = asessServ.getAsessment(asessTemp.getId());
        if (asessment == null) {
            return "redirect:/physical";
        }
        
        Patient patient = patServ.getPatient(patientTemp.getId());
        if (patient == null) {
            return "redirect:/physical";
        }
			
        physicalDetail.setAsessment(asessment);
        physicalDetail.setMedicalRecord(patient.getMedicalRecord());
        psd.savePhysicalDetail(physicalDetail);
        
        asessment.getPhysicalDetailList().add(physicalDetail);
        asessServ.saveAsessment(asessment);
        
        patient.getMedicalRecord().getPhysicalDetailList().add(physicalDetail);
		medicRecServ.saveMedicalRecord(patient.getMedicalRecord());
        
        return "redirect:/dashboard/doctor";
    }
	

}