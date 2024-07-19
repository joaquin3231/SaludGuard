package com.codingdojo.saludGuard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.Location;
import com.codingdojo.saludGuard.models.User;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

	List<Location> findAll();
	
}