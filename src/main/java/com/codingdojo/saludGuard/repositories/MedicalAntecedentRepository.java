package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.MedicalAntecedent;

@Repository
public interface MedicalAntecedentRepository extends CrudRepository<MedicalAntecedent, Long>{

	List<MedicalAntecedent> findAll();
	
	//Llamma a todos los MedicalAntecedent en orden cronologico
	//List<MedicalAntecedent> findAllOrderBycreateAtAsc();
}