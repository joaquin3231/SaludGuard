package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.saludGuard.models.Gender;
import com.codingdojo.saludGuard.models.User;
import com.codingdojo.saludGuard.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService serv;
	
	@GetMapping("/prueba")
	public String prueba() {
		
		return "access_p.jsp";
	}
	
	@GetMapping("/pruebados")
	public String pruebados(@ModelAttribute("newUser") User newUser,
			Model model) {
		
		model.addAttribute("genders", Gender.Genders);
		
		return "register_p.jsp";
	}
	
	@GetMapping("/pruebatres")
	public String pruebatres() {
		
		return "access_d.jsp";
	}
	
	@GetMapping("/dashboard")
	public String landing() {
		
		return "index.jsp";
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser,
						Model model) {
		
		model.addAttribute("gender", Gender.Genders); //Enviar la lista de provincias
		
		return "access.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		serv.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("gender", Gender.Genders); //Enviar la lista de provincias
			return "access.jsp";
		} else {
			//Guardo al nuevo usuario en sesión
			session.setAttribute("userInSession", newUser);
			return "redirect:/dashboard";
		}
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes, /*usar mensajes de Flash*/   
						HttpSession session){
		
		User userTryingLogin = serv.login(email, password); //Obj User o null
		
		if(userTryingLogin == null) {
			//Tiene algo mal
			redirectAttributes.addFlashAttribute("errorLogin", "Wrong email/password");
			return "redirect:/";
		} else {
			session.setAttribute("userInSession", userTryingLogin); //Guardando en sesión el objeto de User
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userInSession");
		return "redirect:/";
	}
	
	//@GetMapping("/physical")
	//public String physical() {
		
	//	return "PhysicalDetail.jsp";
	//}
	
}
