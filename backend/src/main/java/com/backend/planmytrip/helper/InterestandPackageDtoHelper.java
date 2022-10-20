package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.InterestandPackageDto;
import com.backend.planmytrip.entity.InterestandPackage;

@Component
public class InterestandPackageDtoHelper {

	public InterestandPackage convertInterestandPackageDtoToInterestandPackage(InterestandPackageDto dto) {
		InterestandPackage interestandPackage = new InterestandPackage();
		BeanUtils.copyProperties(dto, interestandPackage);
		return interestandPackage;
	}
	
	public InterestandPackageDto convertInterestandPackageToInterestandPackageDto(InterestandPackage interestandPackage) {
		InterestandPackageDto dto = new InterestandPackageDto();
		BeanUtils.copyProperties(interestandPackage, dto);
		return dto;
	}
}
