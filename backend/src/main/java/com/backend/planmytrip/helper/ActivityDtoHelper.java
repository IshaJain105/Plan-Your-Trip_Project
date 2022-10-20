package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.ActivityDto;
import com.backend.planmytrip.entity.Activity;

@Component
public class ActivityDtoHelper {
	
	public Activity convertActivityDtoToActivity(ActivityDto activityDto) {
		Activity activity = new Activity();
		BeanUtils.copyProperties(activityDto, activity);
		return activity;
	}
	
	public ActivityDto convertActivityToActivityDto(Activity activity) {
		ActivityDto activityDto = new ActivityDto();
		BeanUtils.copyProperties(activity, activityDto);
		return activityDto;
	}

}
