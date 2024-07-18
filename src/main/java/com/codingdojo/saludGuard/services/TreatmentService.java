package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.Treatment;
import com.codingdojo.saludGuard.repositories.TreatmentRepository;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentRepository TreatmentRepo;
	
	public Treatment saveTreatment(Treatment newTreatment) {
		return TreatmentRepo.save(newTreatment);
	}
	
	public Treatment getTreatment(Long id) {
		return TreatmentRepo.findById(id).orElse(null);
	}
	
	public void deleteTreatment(Long id) {
		TreatmentRepo.deleteById(id);
	}
	
}
