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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "physical_detais")
public class PhysicalDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Please enter the height of the patient (m)")
	private float height;
	
	@NotNull(message="Please enter the weight of the patient (kg)")
	private float weight;
	
	private float patientIMC;
	
	@NotEmpty(message="Please spectify the blood pressure of the patient (mmHg)")
	@Size(min=2, message = "Blood pressure requires 2 numeric digits at least")
	private String bloodPressure;
	
	@NotEmpty(message="Please spectify the heart rate of the patient (bpm max)")
	@Size(min=2, message = "Heart rate requires 2 numeric digits at least")
	private String heartRate;
	
	@NotEmpty(message="Please enter the body state of the patient")
	@Size(min=2, message = "If it doesn't apply, enter n/a")
	private String bodyState;
	
	@NotEmpty(message="Please enter any observations if needed")
	@Size(min=2, message = "If it doesn't apply, enter n/a")
	private String observ;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//Connections
	
	//physical_detais to asessments (1:n)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assement_id")
	private Asessment asessment;
	
	//physical_detais to medical_redords (1:n)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_record_id")
	private MedicalRecord medicalRecord;
	
	public PhysicalDetail() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getPatientIMC() {
		return patientIMC;
	}
	public void setPatientIMC(float patientIMC) {
		this.patientIMC = patientIMC;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getBodyState() {
		return bodyState;
	}
	public void setBodyState(String bodyState) {
		this.bodyState = bodyState;
	}

	public String getObserv() {
		return observ;
	}
	public void setObserv(String observ) {
		this.observ = observ;
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
	
	public Asessment getAsessment() {
		return asessment;
	}
	public void setAsessment(Asessment asessment) {
		this.asessment = asessment;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	@PrePersist
	protected void onCreate() {
		this.createAt = new Date(); //DEFAULT CURRENT_TIMESTAMP
	}
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date(); //DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	}
}
