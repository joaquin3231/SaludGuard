package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Patient;


@Repository
public interface AsessmentRepository extends CrudRepository<Asessment, Long>{

	List<Asessment> findAll();
	
	//Llamma a todos los Asessment en orden cronologico
	List<Asessment> findAllOrderBycreateAtAsc();
	
	Asessment findByPatient(Patient patient);
	
}
