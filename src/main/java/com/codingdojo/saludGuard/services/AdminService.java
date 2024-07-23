package com.codingdojo.saludGuard.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.saludGuard.models.Admin;
import com.codingdojo.saludGuard.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> findAllAdmins(){
		return adminRepository.findAll();
	}
	
	public Admin registerAdmin(Admin newAdmin, BindingResult result) {
		
		//Comparar las contraseñas
		String password = newAdmin.getPassword();
		String confirm = newAdmin.getConfirm();
		if(!password.equals(confirm)) {
			//SI no son iguales
			//path, clave, mensaje
			result.rejectValue("confirm", "Matches", "Password and confirmation don't match");
		}
		
		//Revisar que el email no esté registrado
		String email = newAdmin.getEmail();
		Admin AdminExist = adminRepository.findByEmail(email); //Objeto de Admin o null
		if(AdminExist != null) {
			//El correo ya está registrado
			result.rejectValue("email", "Unique", "E-mail already exists");
		}
		
		//Si existe error, regreso null
		if(result.hasErrors()) {
			return null;
		} else {
			//NO HAY ERRORES
			//Hashear contraseña
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			newAdmin.setPassword(passHash); //Establecemos el password hasheado
			return adminRepository.save(newAdmin);
		}
		
	}
	
	public Admin login(String email, String password) {
		//Revisamos que el correo exista en BD
		Admin AdminTryingLogin = adminRepository.findByEmail(email); //Objeto Admin o NULL
		
		if(AdminTryingLogin == null) {
			return null;
		}
		
		//Comparar las contraseñas
		//BCrypt.checkpw(Contra NO encriptada, Contra SI encriptada) -> True o False
		if(BCrypt.checkpw(password, AdminTryingLogin.getPassword())) {
			return AdminTryingLogin;
		} else {
			return null;
		}
		
	}
	
	/* Método que en base a un id nos regresa un objeto de Admin */
	public Admin getAdmin(Long id) {
		return adminRepository.findById(id).orElse(null);
	}
	
	//METODO QUE GUARDA USUARIO
	public Admin saveAdmin (Admin admin) {
		return adminRepository.save(admin);
	}
}
