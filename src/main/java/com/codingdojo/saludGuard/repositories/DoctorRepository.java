package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Doctor;
import com.codingdojo.saludGuard.models.User;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{

	List<Doctor> findAll();
	
	Doctor findByUser(User user);
	
}
