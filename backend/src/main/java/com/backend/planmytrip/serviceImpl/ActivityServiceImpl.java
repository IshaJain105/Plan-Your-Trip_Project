package com.backend.planmytrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.planmytrip.dto.ActivityDto;
import com.backend.planmytrip.entity.Activity;
import com.backend.planmytrip.helper.ActivityDtoHelper;
import com.backend.planmytrip.repository.ActivityRepo;
import com.backend.planmytrip.service.ActivityService;

@Service
public class ActivityServiceImpl  implements ActivityService{

	@Autowired private ActivityRepo activityRepo;
	@Autowired private ActivityDtoHelper activityDtoHelper;
	
	@Override
	public List<Activity> getAllActivities(){
		return activityRepo.findAll();
	}
	
	@Override
	public ActivityDto addActivity(ActivityDto activityDto) {
		Activity isActivityExist = activityRepo.findByActivityName(activityDto.getActivityName());
		if(isActivityExist!=null) {
			return null;
		}
		Activity activityAdded  = activityRepo.save(activityDtoHelper.convertActivityDtoToActivity(activityDto));
		return activityDtoHelper.convertActivityToActivityDto(activityAdded);
	}
}
