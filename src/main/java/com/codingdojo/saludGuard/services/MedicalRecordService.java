package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.MedicalRecord;
import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.repositories.MedicalRecordRepository;
import com.codingdojo.saludGuard.repositories.PatientRepository;
import com.codingdojo.saludGuard.repositories.UserRepository;

@Service
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository MedicalRecordRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	public MedicalRecord saveMedicalRecord(MedicalRecord newMedicalRecord) {
		return MedicalRecordRepo.save(newMedicalRecord);
	}
	
	public MedicalRecord getMedicalRecord(Long id) {
		return MedicalRecordRepo.findById(id).orElse(null);
	}
	
	public void deleteMedicalRecord(Long id) {
		MedicalRecordRepo.deleteById(id);
	}
	
	public MedicalRecord getMedicalRecordUser(String userDNI) {
		
		// Selecciona el usuario por medio del dni cargado
		User userSelected = userRepo.findByUserDNI(userDNI);
		
		// Selecciona el paciente por medio del user seleccionado
		Patient patientSelected = patientRepo.findByUser(userSelected);
		
		// retorna medical record del patientSelected
		return patientSelected.getMedicalRecord();
	}
}
