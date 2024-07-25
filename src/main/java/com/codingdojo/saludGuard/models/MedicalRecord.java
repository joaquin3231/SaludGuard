package com.codingdojo.saludGuard.models;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "medical_redords")
public class MedicalRecord {

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
	//medical_redords a asessments( n:1 )
	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY)
	private List<Asessment> assementList;
	
	//medical_redords a treatment( n:1 )
	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY)
	private List<Treatment> treatmentList;
	
	//medical_redords a physical_detais ( n:1 )
	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY)
	private List<PhysicalDetail> physicalDetailList;
	
	//medical_redords a medical_antecedents ( n:1 )
	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY)
	private List<MedicalAntecedent> medicalAntecedentsList;
	
	
	//CONSTRUCTOR
	public MedicalRecord() {}

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
	
	public List<Asessment> getAssementList() {
		return assementList;
	}
	public void setAssementList(List<Asessment> assementList) {
		this.assementList = assementList;
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

	public List<MedicalAntecedent> getMedicalAntecedentsList() {
		return medicalAntecedentsList;
	}
	public void setMedicalAntecedentsList(List<MedicalAntecedent> medicalAntecedentsList) {
		this.medicalAntecedentsList = medicalAntecedentsList;
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
