package com.codingdojo.saludGuard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	public List<User> findAllUsers(){
		return ur.findAll();
	}
}
