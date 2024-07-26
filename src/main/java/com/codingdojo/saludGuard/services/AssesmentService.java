package com.codingdojo.saludGuard.services;

import java.util.Date;
import java.util.List;

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
	
	public List<Asessment> getAsessmentsByDoctorFirstName(String firstName) {
        return asessmentRepo.findByDoctorFirstName(firstName);
    }

    public List<Asessment> getAsessmentsByDate(Date date) {
        return asessmentRepo.findByCreateAt(date);
    }

    public List<Asessment> getAsessmentsByDoctorFirstNameAndDate(String firstName, Date date) {
        return asessmentRepo.findByDoctorFirstNameAndCreateAt(firstName, date);
    }
	
}