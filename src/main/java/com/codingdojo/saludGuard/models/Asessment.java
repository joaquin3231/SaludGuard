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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "asessments")
public class Asessment {
	
	//VARIABLES	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONEXIONES
	//asessments a patients(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", unique = true)
	private Patient patient_id;
	
	//asessments a patients(1:1)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", unique = true)
	private Doctor doctor_id;
	
	//FALTA AGREGAR LAS CONEXIONES PARA MEDICAL RECORD
	//asessments a medical_redords( 1:n )
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_record_id")
	private MedicalRecord medicalRecord;
	
	
	//CONSTRUCTOR
	public Asessment() {}

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public Patient getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Patient patient_id) {
		this.patient_id = patient_id;
	}

	public Doctor getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
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
