package com.backend.planmytrip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.TypeandPackage;

@Repository
public interface TypeandPackageRepo extends JpaRepository<TypeandPackage, Integer>{
	List<TypeandPackage> findByPackageId(Integer packageId);
	List<TypeandPackage> findByTypeId(Integer typeId);
	Integer deleteAllByPackageId(Integer id);
}
