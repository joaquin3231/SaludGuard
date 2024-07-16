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
	
	/*METODO PARA REGISTRAR USUARIO*/
	
	public User register(User newUser, BindingResult result) {
		//COMPARAR CONTRASEÑAS
		String password = newUser.getPassword();
		String confirm = newUser.getComfirm();
		
		//revisar q el email no este registrado
		if(!password.equals(confirm)) {
			
			result.rejectValue("comfirm", "Matches", "Password and confirmation don't match");
		}
	
		String email= newUser.getEmail();
		User userExist = ur.findByEmail(email);
		if(userExist != null) {
			//el correo ya esta registrado
			result.rejectValue("email", "Unique", "Email already exists");
		}
		
		//si existe error , regresa null
		
		if(result.hasErrors()) {
			return null;
		}else {
			//no hay error
			//hashear contraseña
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			
			newUser.setPassword(passHash);
			return ur.save(newUser);
		}
	}
	
	
	public User login (String email, String password) {
		//revisamos que el correo exista en bdd
		User userTryingLogin = ur.findByEmail(email);
		
		if(userTryingLogin == null) {
			return null;
		}
		
		//comparar las contraseñas
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			return userTryingLogin;
		}else {
			return null;
		}
		
		
	}
	
	//METODO QUE GUARDA USUARIO
	public User saveUser (User user) {
		return ur.save(user);
	}
	
	
	
	
}
