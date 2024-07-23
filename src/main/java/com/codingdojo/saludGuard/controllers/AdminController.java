package com.codingdojo.saludGuard.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.saludGuard.models.Admin;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.AdminService;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/access")
	public String adminAccess(@ModelAttribute("newAdmin") Admin newAdmin) {
		
		return "adm_access.jsp";
	}
	
	@GetMapping("/admin/centraldashboard")
	public String adminDashboard(HttpSession session, Model model, User user) {
		
		/*=== REVISION DE SESION ===*/
		Admin adminTemp = (Admin) session.getAttribute("adminInSession"); //Obj User or Null
		
		if(adminTemp == null) {
			
			return "redirect:/home";
		}
		/*=== REVISION DE SESION ===*/
        model.addAttribute("user", user);
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    model.addAttribute("currentTime", now.format(formatter));
		return "adm_dashboard.jsp";
	}
	
	@PostMapping("/admin/searchuser")
	public String adminSearchUser(@ModelAttribute("user") User user, Model model) {
		User searchUser = userService.getUserByUserDNI(user.getUserDNI());
        model.addAttribute("searchResult", searchUser);
        return "adm_dashboard.jsp";
	}
	
	@PostMapping("/admin/register")
	public String registerAdmin(@Valid @ModelAttribute("newAdmin") Admin newAdmin,
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		adminService.registerAdmin(newAdmin, result);
		
		if(result.hasErrors()) {
			
			return "adm_access.jsp";
		} else {
			
			adminService.saveAdmin(newAdmin);
			
			session.setAttribute("adminInSession", newAdmin);
			return "redirect:/admin/centraldashboard";
		}
		
	}
	
	@PostMapping("/admin/login")
	public String loginAdmin(@RequestParam("email") String email,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes, /*usar mensajes de Flash*/   
						HttpSession session){
		
		Admin adminTryingLogin = adminService.login(email, password); //Obj User o null
		
		if(adminTryingLogin == null) {

			redirectAttributes.addFlashAttribute("errorAdminLogin", "Wrong email/password");
			return "redirect:/admin/access";
		} else {
			session.setAttribute("adminInSession", adminTryingLogin); //Guardando en sesión el objeto de User
			
			return "redirect:/admin/centraldashboard";
		}
		
	}
	
	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		session.removeAttribute("adminInSession");
		return "redirect:/home";
	}
}
