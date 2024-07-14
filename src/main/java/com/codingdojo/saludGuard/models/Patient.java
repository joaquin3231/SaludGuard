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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient{

	//VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, message = "First name needs at least 2 chars")
	private String medicaid;
	
	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONEXIONES
	//users a patients(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", unique = true)
	private User user;
	
	//medical_records a patients(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_record_id", unique = true)
	private MedicalRecord medical_id;
	
	
	//CONSTRUCTOR
	public Patient() {
		super();
	}
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicaid() {
		return medicaid;
	}
	public void setMedicaid(String medicaid) {
		this.medicaid = medicaid;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public MedicalRecord getMedical_id() {
		return medical_id;
	}
	public void setMedical_id(MedicalRecord medical_id) {
		this.medical_id = medical_id;
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
