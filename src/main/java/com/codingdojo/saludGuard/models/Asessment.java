package com.codingdojo.saludGuard.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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

	private String observation;
	
	//CONEXIONES
	//asessments a patients(1:1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_Id", unique = false)
	private Patient patient;
	
	//asessments a patients(1:1)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_Id", unique = false)
	private Doctor doctor;
	
	//asessments a medical_redords( 1:n )
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_record_id")
	private MedicalRecord medicalRecord;
	
	//asessments a treatments ( n:1 )
	@OneToMany(mappedBy = "asessment", fetch = FetchType.LAZY)
	private List<Treatment> treatmentList;
	
	//asessments a physical_detais ( n:1 )
	@OneToMany(mappedBy = "asessment", fetch = FetchType.LAZY)
	private List<PhysicalDetail> physicalDetailList;
	
	//asessments a medical_antecedents ( n:1 )
	@OneToMany(mappedBy = "asessment", fetch = FetchType.LAZY)
	private List<MedicalAntecedent> medicalAntecedents;
	
	//CONSTRUCTOR
	public Asessment() {
		this.treatmentList = new ArrayList<>();
		this.physicalDetailList = new ArrayList<>();
		this.medicalAntecedents = new ArrayList<>();
	}

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

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public List<Treatment> getTreatmentList() {
		return treatmentList;
	}
	public void setTreatmentList(List<Treatment> treatmentList) {
		this.treatmentList = treatmentList;
	}

	public List<PhysicalDetail> getPhysicalDetailList() {
		return physicalDetailList;
	}
	public void setPhysicalDetailList(List<PhysicalDetail> physicalDetailList) {
		this.physicalDetailList = physicalDetailList;
	}

	public List<MedicalAntecedent> getMedicalAntecedents() {
		return medicalAntecedents;
	}
	public void setMedicalAntecedents(List<MedicalAntecedent> medicalAntecedents) {
		this.medicalAntecedents = medicalAntecedents;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
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
