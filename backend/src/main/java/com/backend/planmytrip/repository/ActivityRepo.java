package com.backend.planmytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.planmytrip.entity.Activity;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Integer>{
	Activity findByActivityName(String activityName);
}
