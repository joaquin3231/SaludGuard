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
	
	@NotEmpty(message="Ingrese una dirección válida")
	@Size(min=2, message = "Ingrese una dirección válida")
	private String address;
	
	private String address2;
	
	@NotEmpty(message="Seleccione una provincia")
	@Size(min=2, message = "Provincia")
	private String state;
	
	@NotNull(message="Escriba un código postal")
	@Size(min=4, message = "El código postal debe ser de al menos 4 dígitos")
	private String postalCode;
	
	@NotEmpty(message="Ingrese una localidad")
	@Size(min=2, message = "Ingrese una localidad válida")
	private String town;
	
	@NotEmpty(message="Seleccione una ciudad/municipio")
	@Size(min=2, message = "Municipio")
	private String city;
	
	//locations a users(1:1)
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
