package com.backend.planmytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.AreaOfInterest;

@Repository
public interface AreaOfInterestRepo extends JpaRepository<AreaOfInterest, Integer>{
	AreaOfInterest findByName(String name);
}
