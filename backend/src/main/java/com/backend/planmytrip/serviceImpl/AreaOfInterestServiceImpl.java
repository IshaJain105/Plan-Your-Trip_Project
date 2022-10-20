package com.backend.planmytrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.planmytrip.dto.AreaOfInterestDto;
import com.backend.planmytrip.entity.AreaOfInterest;
import com.backend.planmytrip.helper.AreaOfInterestDtoHelper;
import com.backend.planmytrip.repository.AreaOfInterestRepo;
import com.backend.planmytrip.service.AreaOfInterestService;

@Service
public class AreaOfInterestServiceImpl implements AreaOfInterestService{

	@Autowired private AreaOfInterestRepo areaOfInterestRepo;
	@Autowired private AreaOfInterestDtoHelper areaOfInterestDtoHelper;
	
	@Override
	public List<AreaOfInterest> getAllOfAreaOfInterest() {
		return areaOfInterestRepo.findAll();
	}
	
	@Override
	public AreaOfInterestDto addInterest(AreaOfInterestDto interestDto) {
		AreaOfInterest isInterestExist = areaOfInterestRepo.findByName(interestDto.getName());
		if(isInterestExist!=null) {
			return null;
		}
		AreaOfInterest interestAdded  = areaOfInterestRepo.save(areaOfInterestDtoHelper.convertAreaOfInterestDtoToAreaOfInterest(interestDto));
		return areaOfInterestDtoHelper.convertAreaOfInterestToAreaOfInterestDto(interestAdded);
	}
}
