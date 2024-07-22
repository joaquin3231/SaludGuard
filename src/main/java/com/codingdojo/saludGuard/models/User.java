package com.codingdojo.saludGuard.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@NotEmpty(message="First name is required")
	@Size(min=2, message = "First name needs at least 2 chars")
	private String firstName;
	
	@NotEmpty(message="Last name is required")
	@Size(min=2, message = "Last name needs at least 2 chars")
	private String lastName;
	
	@NotNull(message="DNI is required")
	@Size(min=8, max=8, message = "DNI needs at least 8 chars, and max 8")
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
	
	@NotEmpty(message = "gender is required")
	private String gender;
	
	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONEXIONES
	//users a locations(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", unique = true)
	private Location location;
	
	//CONSTRUCTOR
	public User() {}

	//GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
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
		this.createAt = new Date(); 
	}
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); 
	}
}
