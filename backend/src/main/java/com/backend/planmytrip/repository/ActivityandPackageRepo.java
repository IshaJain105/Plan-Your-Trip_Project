package com.backend.planmytrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.ActivityandPackage;

@Repository
public interface ActivityandPackageRepo extends JpaRepository<ActivityandPackage, Integer>{
	List<ActivityandPackage> findByCityId(Integer cityId);
	List<ActivityandPackage> findByActivityId(Integer activityId);
	Integer deleteAllByCityId(Integer id);
}
