package com.codingdojo.saludGuard.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	//VARIABLES	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="First name ir required")
	@Size(min=2, message = "First name needs at least 2 chars")
	private String firstName;
	
	@NotEmpty(message="Last name ir required")
	@Size(min=2, message = "Last name needs at least 2 chars")
	private String lastName;
	
	@NotNull(message="DNI is required")
	@Size(min=2, message = "DNI needs at least 2 chars")
	private String userDNI;
	
	@NotNull(message="Phone is required")
	@Size(min=8, max=20, message = "Phone needs at least 8 chars")
	private String phone;
	
	@Email(message = "Invalid email")
	private String emailContact;
	
	@NotEmpty(message="email ir required")
	@Email(message = "Invalid email")
	private String email;
	
	@NotEmpty(message="password ir required")
	@Size(min=6, message = "Password needs at least 2 chars")
	private String password;
	
	@Transient
	@NotEmpty(message="comfirm ir required")
	@Size(min=6, message = "Comfirm needs at least 2 chars")
	private String comfirm;
	
	// No se le agrega anotación, ya que si o si se va a cargar el género
	private String gender;
	
	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONEXIONES

	
	//CONSTRUCTOR
	public User() {}

	//GETTERS AND SETTERS
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
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

	public String getComfirm() {
		return comfirm;
	}
	public void setComfirm(String comfirm) {
		this.comfirm = comfirm;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@PrePersist //Antes de hacer la creacion
	protected void onCreate() {
		this.createAt = new Date(); //DEFAULT CURRENT_TIMESTAMP
	}
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); //DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
}
