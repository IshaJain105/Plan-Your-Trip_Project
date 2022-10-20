package com.backend.planmytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.Type;

@Repository
public interface TypeRepo extends JpaRepository<Type, Integer>{
	Type findByName(String name);
}
