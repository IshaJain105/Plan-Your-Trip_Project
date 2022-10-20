package com.backend.planmytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.Package;

@Repository
public interface PackageRepo extends JpaRepository<Package, Integer>{
	Package findByCityName(String cityName);
}
