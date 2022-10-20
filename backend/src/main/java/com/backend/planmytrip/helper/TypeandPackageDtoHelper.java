package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.TypeandPackageDto;
import com.backend.planmytrip.entity.TypeandPackage;

@Component
public class TypeandPackageDtoHelper {

	public TypeandPackage convertTypeandPackageDtoToTypeandPackage(TypeandPackageDto dto) {
		TypeandPackage package1 = new TypeandPackage();
		BeanUtils.copyProperties(dto, package1);
		return package1;
	}
	
	public TypeandPackageDto convertTypeandPackageToTypeandPackageDto(TypeandPackage package1) {
		TypeandPackageDto dto = new TypeandPackageDto();
		BeanUtils.copyProperties(package1, dto);
		return dto;
	}
}
