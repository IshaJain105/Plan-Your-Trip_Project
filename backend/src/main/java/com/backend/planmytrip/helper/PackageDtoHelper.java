package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.PackageDto;
import com.backend.planmytrip.entity.Package;

@Component
public class PackageDtoHelper {

	public Package convertPackageDtoToPackage(PackageDto dto) {
		Package package1 = new Package();
		BeanUtils.copyProperties(dto, package1);
		return package1;
	}
	
	public PackageDto convertPackageToPackageDto(Package package1) {
		PackageDto dto = new PackageDto();
		BeanUtils.copyProperties(package1, dto);
		return dto;
	}
}
