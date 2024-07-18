package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.PhysicalDetail;
import com.codingdojo.saludGuard.repositories.PhysicalDetailRepository;

@Service
public class PhysicalDetailService {

	@Autowired
	private PhysicalDetailRepository PhysicalDetailRepo;
	
	public PhysicalDetail savePhysicalDetail(PhysicalDetail newPhysicalDetail) {
		return PhysicalDetailRepo.save(newPhysicalDetail);
	}
	
	public PhysicalDetail getPhysicalDetail(Long id) {
		return PhysicalDetailRepo.findById(id).orElse(null);
	}
	
	public void deletePhysicalDetail(Long id) {
		PhysicalDetailRepo.deleteById(id);
	}
	
}
