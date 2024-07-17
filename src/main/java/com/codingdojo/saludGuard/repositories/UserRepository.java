package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.User;

@Repository

public interface UserRepository extends CrudRepository<User,Long>{
	
	User findByEmail(String email);
	
	List<User> findAll();
	
	//ENCONTRAR EL USUARIO POR DNI
	User findByUserDNI(String userDni);
	
	
}
