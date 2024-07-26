package com.codingdojo.saludGuard.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.MedicalAntecedent;
import com.codingdojo.saludGuard.models.MedicalRecord;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.PhysicalDetail;
import com.codingdojo.saludGuard.models.Treatment;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.AssesmentService;
import com.codingdojo.saludGuard.services.DoctorService;
import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AssesmentController {

	@Autowired
	private DoctorService docServ;
	
	@Autowired
	private AssesmentService asessServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private PatientService patServ;
	
	@Autowired
	private MedicalRecordService medicRecServ;
	
	@GetMapping("/findPatient")
	public String findPatientAsses(HttpSession session) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		return "formDniPatient.jsp";
	}
	
	@PostMapping("/getPatient")
	public String getPatientAsses(@RequestParam("dniPaciente") String dniPaciente,
							HttpSession session, RedirectAttributes redirectAttributes) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		User user = userServ.getUserByUserDNI(dniPaciente);
		Patient patient = patServ.getPatientByUser(user);
		
		if(patient == null) {
			redirectAttributes.addFlashAttribute("errorFind", "patient does not exist");
			return "redirect:/findPatient";
		}
		
		session.setAttribute("patientTemp", patient);
		return "redirect:/dashboard/doctor";
	}
	
	@GetMapping("/dashboard/doctor")
	public String dashboardDoctor(HttpSession session, Model model) {
		
		 /*=== REVISION DE SESION ===*/
        Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

        if (doctTemp == null) {
            return "redirect:/inicioSesion/doc";
        }
        /*=== REVISION DE SESION ===*/

        // Obtener doctor de la base de datos para asegurar que está gestionado
        Doctor doctor = docServ.getDoctor(doctTemp.getId());
        if (doctor == null) {
            return "redirect:/inicioSesion/doc";
        }

        // Obtener patient de la sesión y desde el servicio para asegurar que está gestionado
        Patient patientTemp = (Patient) session.getAttribute("patientTemp");
        Patient patient = patServ.getPatient(patientTemp.getId());
        if (patient == null) {
            return "redirect:/findPatient";
        }

        // Obtener el registro médico desde el servicio para asegurar que está gestionado
        MedicalRecord medicalRecord = medicRecServ.getMedicalRecord(patient.getMedicalRecord().getId());
        if (medicalRecord == null) {
            return "redirect:/findPatient";
        }

        Asessment newAsessment = new Asessment();

        if (session.getAttribute("antecedentTemp") != null) {
        	Asessment asessTemp = (Asessment) session.getAttribute("antecedentTemp");
            
            newAsessment = asessServ.getAsessment(asessTemp.getId());
        }

        newAsessment.setPatient(patient); //cargamos el paciente a la consulta
        newAsessment.setDoctor(doctor); //cargamos el doctor a la consulta
        newAsessment.setMedicalRecord(medicalRecord);

        medicalRecord.getAssementList().add(newAsessment);
        asessServ.saveAsessment(newAsessment);

        medicRecServ.saveMedicalRecord(medicalRecord);

        session.setAttribute("antecedentTemp", newAsessment);
        
        
		//CONSULTAS
		//Obtener la lista de consultas del historial clinico del paciente
		List<Asessment> patientAssesments = patient.getMedicalRecord().getAssementList();
		
		//Obtenemos Las ultimas tres consultas
		List<Asessment> aseesmentList = new ArrayList<>();
		for (int i = (patientAssesments.size() - 1);i >= patientAssesments.size() - 6; i-- ) {
			if(i < 0) {
				break;
			} else {
				aseesmentList.add(patientAssesments.get(i));
			}
		}
		model.addAttribute("assesmentList", aseesmentList);
		
		//DETALLES FISICOS
		//Obtenemos la lista de detalles fisico
		List<PhysicalDetail> physicalList = medicalRecord.getPhysicalDetailList();
		
		//Obtenemos el ultimo detalle fisico
		
		if(physicalList.size() != 0) {
			PhysicalDetail physicalDetail = physicalList.get(physicalList.size() - 1);
			model.addAttribute("physicalDetail", physicalDetail);
		}
		
		//TRATAMIENTOS
		//Obtenemos la lista de tratamientos
		List<Treatment> treatmentList = medicalRecord.getTreatmentList();
		
		//Obtenemos el ultimo tratamiento hecho
		
		if(treatmentList.size() != 0) {
			Treatment treatment = treatmentList.get(treatmentList.size() - 1);
			model.addAttribute("treatment", treatment);			
		}
		
		//ANTECEDENTES MEDICOS
		List<MedicalAntecedent> antecedentList = medicalRecord.getMedicalAntecedentsList();
		
		//Obtenemos el ultimo antecedente hecho
		if(antecedentList.size() != 0) {
			MedicalAntecedent antecedent = antecedentList.get(antecedentList.size() - 1);
			
			SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatFecha.format(antecedent.getStudyDate());
			
			model.addAttribute("antecedentDate", fecha);
			model.addAttribute("antecedent", antecedent);
		}
        
        
        
        return "dashboard_d.jsp";
        
	}
	
	@GetMapping("/existConsult")
	public String finishConsult(HttpSession session) {
		/*=== REVISION DE SESION ===*/
		Doctor doctTemp = (Doctor) session.getAttribute("doctTemp"); //Obj User or Null

		if(doctTemp == null) {
			
			return "redirect:/inicioSesion/doc";
		}
		/*=== REVISION DE SESION ===*/
		
		session.removeAttribute("antecedentTemp");
		
		return "redirect:/findPatient";
	}
}
