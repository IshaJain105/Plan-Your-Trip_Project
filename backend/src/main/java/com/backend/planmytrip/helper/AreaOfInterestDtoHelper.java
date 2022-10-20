package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.AreaOfInterestDto;
import com.backend.planmytrip.entity.AreaOfInterest;

@Component
public class AreaOfInterestDtoHelper {

	public AreaOfInterest convertAreaOfInterestDtoToAreaOfInterest(AreaOfInterestDto areaOfInterestDto) {
		AreaOfInterest areaOfInterest = new AreaOfInterest();
		BeanUtils.copyProperties(areaOfInterestDto, areaOfInterest);
		return areaOfInterest;
	}
	
	public AreaOfInterestDto convertAreaOfInterestToAreaOfInterestDto(AreaOfInterest areaOfInterest) {
		AreaOfInterestDto areaOfInterestDto = new AreaOfInterestDto();
		BeanUtils.copyProperties(areaOfInterest, areaOfInterestDto);
		return areaOfInterestDto;
	}
}
