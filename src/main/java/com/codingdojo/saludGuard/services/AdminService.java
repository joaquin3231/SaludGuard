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
		
		String password = newAdmin.getPassword();
		String confirm = newAdmin.getConfirm();
		if(!password.equals(confirm)) {
			
			result.rejectValue("confirm", "Matches", "Password and confirmation don't match");
		}
		
		String email = newAdmin.getEmail();
		Admin AdminExist = adminRepository.findByEmail(email);
		if(AdminExist != null) {
			
			result.rejectValue("email", "Unique", "E-mail already exists");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			newAdmin.setPassword(passHash); 
			return adminRepository.save(newAdmin);
		}
		
	}
	
	public Admin login(String email, String password) {

		Admin AdminTryingLogin = adminRepository.findByEmail(email);
		
		if(AdminTryingLogin == null) {
			return null;
		}
		
		if(BCrypt.checkpw(password, AdminTryingLogin.getPassword())) {
			return AdminTryingLogin;
		} else {
			return null;
		}
		
	}
	
	public Admin getAdmin(Long id) {
		return adminRepository.findById(id).orElse(null);
	}
	
	public Admin saveAdmin (Admin admin) {
		return adminRepository.save(admin);
	}
}
