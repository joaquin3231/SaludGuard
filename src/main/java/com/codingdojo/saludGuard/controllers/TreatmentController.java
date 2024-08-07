package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.Treatment;
import com.codingdojo.saludGuard.services.AssesmentService;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.TreatmentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class TreatmentController {

	@Autowired
	private TreatmentService treatServ;
	
	@Autowired
	private AssesmentService asessServ;
	
	@Autowired
	private MedicalRecordService medicRecServ;
	
	@Autowired
	private DoctorService docServ;
	
	@Autowired
	private PatientService patServ;
	
	@GetMapping("/treatment")
	public String treatmentForm(@ModelAttribute("treatmentNew") Treatment treatment,
								HttpSession session) {

		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp");

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
			
		return "treatment.jsp";
	}
	
	@PostMapping("/treatment/save")
	public String treatmentFormSave(@Valid @ModelAttribute("treatmentNew") Treatment treatment,
									HttpSession session, BindingResult result) {
		
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp");

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		
		if(result.hasErrors()) {
			return "treatment.jsp";
		} else {
			Asessment asessTemp = (Asessment) session.getAttribute("antecedentTemp");
			Patient patientTemp = (Patient) session.getAttribute("patientTemp");
			
			Asessment asessment = asessServ.getAsessment(asessTemp.getId());
	        if (asessment == null) {
	            return "redirect:/treatment";
	        }
	        
	        Patient patient = patServ.getPatient(patientTemp.getId());
	        if (patient == null) {
	            return "redirect:/treatment";
	        }
			
			treatment.setAsessment(asessment);
			treatment.setMedicalRecord(patient.getMedicalRecord());
			treatServ.saveTreatment(treatment);
			
			asessment.getTreatmentList().add(treatment);
			asessServ.saveAsessment(asessment);
			
			patient.getMedicalRecord().getTreatmentList().add(treatment);
			medicRecServ.saveMedicalRecord(patient.getMedicalRecord());
			
			return "redirect:/dashboard/doctor";
		}
	}
	
	
}
