package com.backend.planmytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{
	public Flight findByPackageId(Integer packageId);
}
