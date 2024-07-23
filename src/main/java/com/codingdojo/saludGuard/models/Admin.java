package com.codingdojo.saludGuard.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required")
	@Size(min=2, message = "Name needs at least 2 chars")
	private String name;
	
	@NotNull(message="DNI is required")
	@Size(min=7, max=9, message = "DNI needs at least 8 chars, and max 8")
	private String userDNI;
	
	@NotNull(message="Phone is required")
	@Size(min=8, max=20, message = "Phone needs at least 8 chars")
	private String phone;
	
	@NotEmpty(message="email is required")
	@Email(message = "Invalid email")
	private String email;
	
	@NotEmpty(message="password is required")
	@Size(min=6, message = "Password needs at least 2 chars")
	private String password;
	
	@Transient
	@Size(min=6, message = "Confirm needs at least 2 chars")
	private String confirm;
	
	//CONSTRUCTOR
	public Admin() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserDNI() {
		return userDNI;
	}

	public void setUserDNI(String userDNI) {
		this.userDNI = userDNI;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
}
