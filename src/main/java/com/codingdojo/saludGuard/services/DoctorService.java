package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.repositories.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository DoctorRepo;
	
	public Doctor saveDoctor(Doctor newDoctor) {
		return DoctorRepo.save(newDoctor);
	}
	
	public Doctor getDoctor(Long id) {
		return DoctorRepo.findById(id).orElse(null);
	}
	
	public void deleteDoctor(Long id) {
		DoctorRepo.deleteById(id);
	}
}
