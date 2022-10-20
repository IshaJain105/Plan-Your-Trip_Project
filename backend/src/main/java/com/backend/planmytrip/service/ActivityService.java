package com.backend.planmytrip.service;

import java.util.List;

import com.backend.planmytrip.dto.ActivityDto;
import com.backend.planmytrip.entity.Activity;

public interface ActivityService {
	
	public List<Activity> getAllActivities();
	public ActivityDto addActivity(ActivityDto activityDto);
}
