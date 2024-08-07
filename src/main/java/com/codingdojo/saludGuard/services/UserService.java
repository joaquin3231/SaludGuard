package com.codingdojo.saludGuard.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	public List<User> findAllUsers(){
		return ur.findAll();
	}
	
	public User register(User newUser, BindingResult result) {
		
		String password = newUser.getPassword();
		String confirm = newUser.getConfirm();
		if(!password.equals(confirm)) {

			result.rejectValue("confirm", "Matches", "Las contraseñas no coinciden, asegúrese de confirmar su contraseña correctamente");
		}
		
		String email = newUser.getEmail();
		User userExist = ur.findByEmail(email);
		if(userExist != null) {

			result.rejectValue("email", "Unique", "El e-mail registrado ya existe, por favor ingrese otro, o contáctese a contacto@saludguard.com");
		}
		
		String userDNI = newUser.getUserDNI();
		User userExist2 = ur.findByUserDNI(userDNI);
		if(userExist2 != null) {

			result.rejectValue("userDNI", "Unique", "El DNI registrado ya existe, por favor ingrese otro, o contáctese a contacto@saludguard.com");
		}
		

		if(result.hasErrors()) {
			
			return null;
		} else {

			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(passHash);
			return ur.save(newUser);
		}
		
	}
	
	public User login(String email, String password) {

		User userTryingLogin = ur.findByEmail(email); 
		
		if(userTryingLogin == null) {
			
			return null;
		}
		
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			
			return userTryingLogin;
		} else {
			
			return null;
		}
		
	}
	
	public User loginByDni(String dni, String password) {

		User userTryingLogin = ur.findByUserDNI(dni); //Objeto User o NULL
		
		if(userTryingLogin == null) {
			
			return null;
		}
		
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			
			return userTryingLogin;
		} else {
			
			return null;
		}
		
	}
	
	public User getUser(Long id) {
		return ur.findById(id).orElse(null);
	}
	
	public User saveUser (User user) {
		return ur.save(user);
	}
	
	public User getUserByUserDNI(String userDNI) {
		return ur.findByUserDNI(userDNI);
	}
	
}
