package com.backend.planmytrip.service;

import java.util.List;

import com.backend.planmytrip.dto.AreaOfInterestDto;
import com.backend.planmytrip.entity.AreaOfInterest;

public interface AreaOfInterestService {
	public List<AreaOfInterest> getAllOfAreaOfInterest();
	public AreaOfInterestDto addInterest(AreaOfInterestDto interestDto);
}
