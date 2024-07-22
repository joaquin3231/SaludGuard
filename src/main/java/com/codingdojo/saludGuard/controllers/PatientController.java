package com.codingdojo.saludGuard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codingdojo.saludGuard.services.MedicalRecordService;
import com.codingdojo.saludGuard.services.PatientService;
import com.codingdojo.saludGuard.services.UserService;

@Controller
public class PatientController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private PatientService patServ;
	
	@Autowired
	private MedicalRecordService mrServ;
	
}
