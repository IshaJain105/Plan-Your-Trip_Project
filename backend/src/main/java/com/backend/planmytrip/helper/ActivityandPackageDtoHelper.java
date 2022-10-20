package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.ActivityandPackageDto;
import com.backend.planmytrip.entity.ActivityandPackage;

@Component
public class ActivityandPackageDtoHelper {

	public ActivityandPackageDto convertActivityandPackageToActivityandPackageDto(ActivityandPackage activityandPackage) {
		ActivityandPackageDto activityandPackageDto = new ActivityandPackageDto();
		BeanUtils.copyProperties(activityandPackage, activityandPackageDto);
		return activityandPackageDto;
	}
	
	public ActivityandPackage convertActivityandPackageDtoToActivityandPackage(ActivityandPackageDto activityandPackageDto) {
		ActivityandPackage activityandPackage = new ActivityandPackage();
		BeanUtils.copyProperties(activityandPackageDto, activityandPackage);
		return activityandPackage;
	}
}
