package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.User;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	User findByEmail(String email);
	User findByUserDNI(String userDNI);
	
}