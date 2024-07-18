package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Patient;
import com.codingdojo.saludGuard.models.User;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

	List<Patient> findAll();
	
	Patient findByUser(User user);
	
}
