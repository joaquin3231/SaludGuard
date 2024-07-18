package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.repositories.AsessmentRepository;

@Service
public class AssesmentService {

	@Autowired
	private AsessmentRepository asessmentRepo;
	
	public Asessment saveAsessment(Asessment newAsessment) {
		return asessmentRepo.save(newAsessment);
	}
	
	public Asessment getAsessment(Long id) {
		return asessmentRepo.findById(id).orElse(null);
	}
	
	public void deleteAsessment(Long id) {
		asessmentRepo.deleteById(id);
	}
}