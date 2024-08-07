package com.codingdojo.saludGuard.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Asessment;
import com.codingdojo.saludGuard.models.Patient;

@Repository
public interface AsessmentRepository extends CrudRepository<Asessment, Long>{

	List<Asessment> findAll();
	
	Asessment findByPatient(Patient patient);
	
	@Query("SELECT a FROM Asessment a WHERE FUNCTION('DATE', a.createAt) = :date")
    List<Asessment> findByCreateAtIgnoringTime(@Param("date") Date date);
	@Query("SELECT a FROM Asessment a WHERE a.doctor.user.firstName LIKE %:firstName%")
	List<Asessment> findByDoctorFirstName(@Param("firstName") String firstName);
	@Query("SELECT a FROM Asessment a WHERE a.doctor.user.firstName LIKE %:firstName% AND FUNCTION('DATE', a.createAt) = FUNCTION('DATE', :createAt)")
	List<Asessment> findByDoctorFirstNameAndCreateAt(@Param("firstName") String firstName, @Param("createAt") Date createAt);

	
}
