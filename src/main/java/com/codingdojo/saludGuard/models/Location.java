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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "locations")
public class Location {

	//VARIABLES	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Address is required")
	@Size(min=2, message = "Address needs at least 2 chars")
	private String address;
	
	@Size(min=2, message = "Address needs at least 2 chars")
	private String address2;
	
	@NotEmpty(message="State is required")
	@Size(min=2, message = "State needs at least 2 chars")
	private String state;
	
	@NotNull(message="State is required")
	@Size(min=4, message = "State needs at least 2 chars")
	private String postalCode;
	
	@NotEmpty(message="State is required")
	@Size(min=2, message = "State needs at least 2 chars")
	private String town;
	
	@NotEmpty(message="City is required")
	@Size(min=2, message = "City needs at least 2 chars")
	private String city;
	
	//locations a users(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", unique = true)
	private User user;
	
	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONSTRUCTORES
	public Location() {}

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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
