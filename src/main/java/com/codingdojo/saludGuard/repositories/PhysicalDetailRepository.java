package com.codingdojo.saludGuard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.saludGuard.models.PhysicalDetail;

@Repository
public interface PhysicalDetailRepository extends CrudRepository<PhysicalDetail, Long> {

}
