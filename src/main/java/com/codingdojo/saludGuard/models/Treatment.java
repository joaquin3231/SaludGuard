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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "treatments")
public class Treatment {

	//VARIABLES	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Especifique el tipo de tratamiento")
	@Size(min=2, message = "Especifique el tipo de tratamiento (si no aplica, escriba n/a)")
	private String type;
	
	@NotEmpty(message="Especifique la descripción del tratamiento")
	@Size(min=2, message = "Especifique la descripción del tratamiento (si no aplica, escriba n/a)")
	private String description;
	
	@Column(updatable = false)//Este atributo solo se agrega 1 vez, y NUNCA se actualiza
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;
	
	//CONEXIONES
	//treatments a asessments ( 1:n )
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "assement_id")
	private Asessment asessment;
	
	//treatments a medical_redords ( 1:n )
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_record_id")
	private MedicalRecord medicalRecord;
	
	//CONSTRUCTOR
	public Treatment() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	@PrePersist //Antes de hacer la creacion
	protected void onCreate() {
		this.createAt = new Date();
	}
	@PreUpdate 
	protected void onUpdate() {
		this.updateAt = new Date();
	}
}
