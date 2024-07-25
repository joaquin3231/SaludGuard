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
import com.codingdojo.saludGuard.models.MedicalAntecedent;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.TypeAntecedentMedical;
import com.codingdojo.saludGuard.services.AssesmentService;
import com.codingdojo.saludGuard.services.MedicalAntecedentService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MedicalAntecedentController {

	@Autowired
	private MedicalAntecedentService medAntServ;
	
	@Autowired
	private AssesmentService asessServ;
	
	@Autowired
	private MedicalRecordService medicRecServ;
	
	@Autowired
	private PatientService patServ;
	
	@GetMapping("/antecedent")
	public String antecedentForm(	@ModelAttribute("antecedent") MedicalAntecedent antecedent,
									HttpSession session, Model model) {
		
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		model.addAttribute("typeAntecedents", TypeAntecedentMedical.Types);
		
		return "antecedent.jsp";
	}
	
	@PostMapping("/antecedent/save")
	public String antecedentFormSave(	@Valid @ModelAttribute("antecedent") MedicalAntecedent antecedent,
										BindingResult result,HttpSession session, Model model) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		if(result.hasErrors()) {
			
			model.addAttribute("typeAntecedents", TypeAntecedentMedical.Types);
			
			return "antecedent.jsp";
			
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
			
	        antecedent.setAsessment(asessment);
	        antecedent.setMedicalRecord(patient.getMedicalRecord());
			medAntServ.saveMedicalAntecedent(antecedent);
	        
			asessment.getMedicalAntecedents().add(antecedent);
			asessServ.saveAsessment(asessment);
			
			patient.getMedicalRecord().getMedicalAntecedentsList().add(antecedent);
			medicRecServ.saveMedicalRecord(patient.getMedicalRecord());
	        
			return "redirect:/dashboard/doctor";
		}
	}
}
