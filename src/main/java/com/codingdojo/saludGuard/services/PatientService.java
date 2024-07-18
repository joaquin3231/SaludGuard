package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository PatientRepo;
	
	public Patient savePatient(Patient newPatient) {
		return PatientRepo.save(newPatient);
	}
	
	public Patient getPatient(Long id) {
		return PatientRepo.findById(id).orElse(null);
	}
	
	public void deletePatient(Long id) {
		PatientRepo.deleteById(id);
	}
	
}
