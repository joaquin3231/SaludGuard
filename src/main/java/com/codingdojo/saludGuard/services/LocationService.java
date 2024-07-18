package com.codingdojo.saludGuard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.saludGuard.models.Location;
import com.codingdojo.saludGuard.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository LocationRepo;
	
	public Location saveLocation(Location newLocation) {
		return LocationRepo.save(newLocation);
	}
	
	public Location getLocation(Long id) {
		return LocationRepo.findById(id).orElse(null);
	}
	
	public void deleteLocation(Long id) {
		LocationRepo.deleteById(id);
	}
	
}
