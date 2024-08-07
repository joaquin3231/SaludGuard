package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Admin;

@Repository

public interface AdminRepository extends CrudRepository<Admin, Long>{

	List<Admin> findAll();
	
	Admin findByEmail(String email);
	Admin findByUserDNI(String userDNI);
	
}
