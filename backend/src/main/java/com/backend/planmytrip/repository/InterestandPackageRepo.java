package com.backend.planmytrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.InterestandPackage;

@Repository
public interface InterestandPackageRepo extends JpaRepository<InterestandPackage, Integer>{
	List<InterestandPackage> findByCityId(Integer cityId);
	List<InterestandPackage> findByAreaOfInterestId(Integer areaOfInterestId);
	Integer deleteAllByCityId(Integer id);
}
