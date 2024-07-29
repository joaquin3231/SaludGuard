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
	
	/*Método que registre a un nuevo usuario*/
	public User register(User newUser, BindingResult result) {
		
		//Comparar las contraseñas
		String password = newUser.getPassword();
		String confirm = newUser.getConfirm();
		if(!password.equals(confirm)) {
			//SI no son iguales
			//path, clave, mensaje
			result.rejectValue("confirm", "Matches", "Las contraseñas no coinciden, asegúrese de confirmar su contraseña correctamente");
		}
		
		//Revisar que el email no esté registrado
		String email = newUser.getEmail();
		User userExist = ur.findByEmail(email); //Objeto de User o null
		if(userExist != null) {
			//El correo ya está registrado
			result.rejectValue("email", "Unique", "El e-mail registrado ya existe, por favor ingrese otro, o contáctese a contacto@saludguard.com");
		}
		
		//Revisar que el email no esté registrado
		String userDNI = newUser.getUserDNI();
		User userExist2 = ur.findByUserDNI(userDNI); //Objeto de User o null
		if(userExist2 != null) {
			//El DNI ya está registrado
			result.rejectValue("userDNI", "Unique", "El DNI registrado ya existe, por favor ingrese otro, o contáctese a contacto@saludguard.com");
				}
		
		//Si existe error, regreso null
		if(result.hasErrors()) {
			return null;
		} else {
			//NO HAY ERRORES
			//Hashear contraseña
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(passHash); //Establecemos el password hasheado
			return ur.save(newUser);
		}
		
	}
	
	/*Método que revisa que los datos sean correctos para Iniciar Sesión*/
	public User login(String email, String password) {
		//Revisamos que el correo exista en BD
		User userTryingLogin = ur.findByEmail(email); //Objeto User o NULL
		
		if(userTryingLogin == null) {
			return null;
		}
		
		//Comparar las contraseñas
		//BCrypt.checkpw(Contra NO encriptada, Contra SI encriptada) -> True o False
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			return userTryingLogin;
		} else {
			return null;
		}
		
	}
	
	public User loginByDni(String dni, String password) {
		//Revisamos que el correo exista en BD
		User userTryingLogin = ur.findByUserDNI(dni); //Objeto User o NULL
		
		if(userTryingLogin == null) {
			return null;
		}
		
		//Comparar las contraseñas
		//BCrypt.checkpw(Contra NO encriptada, Contra SI encriptada) -> True o False
		if(BCrypt.checkpw(password, userTryingLogin.getPassword())) {
			return userTryingLogin;
		} else {
			return null;
		}
		
	}
	
	/* Método que en base a un id nos regresa un objeto de User */
	public User getUser(Long id) {
		return ur.findById(id).orElse(null);
	}
	
	//METODO QUE GUARDA USUARIO
	public User saveUser (User user) {
		return ur.save(user);
	}
	
	public User getUserByUserDNI(String userDNI) {
		return ur.findByUserDNI(userDNI);
	}
	
	
	
}
