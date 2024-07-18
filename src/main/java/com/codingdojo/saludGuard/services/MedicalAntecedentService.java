package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.MedicalAntecedent;
import com.codingdojo.saludGuard.repositories.MedicalAntecedentRepository;

@Service
public class MedicalAntecedentService {

	@Autowired
	private MedicalAntecedentRepository MedicalAntecedentRepo;
	
	public MedicalAntecedent saveMedicalAntecedent(MedicalAntecedent newMedicalAntecedent) {
		return MedicalAntecedentRepo.save(newMedicalAntecedent);
	}
	
	public MedicalAntecedent getMedicalAntecedent(Long id) {
		return MedicalAntecedentRepo.findById(id).orElse(null);
	}
	
	public void deleteMedicalAntecedent(Long id) {
		MedicalAntecedentRepo.deleteById(id);
	}
	
}
