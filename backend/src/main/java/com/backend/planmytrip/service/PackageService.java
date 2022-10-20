package com.backend.planmytrip.service;

import java.util.List;
import java.util.Map;

import com.backend.planmytrip.dto.PackageDto;
import com.backend.planmytrip.entity.Package;

public interface PackageService {
	
	public List<Package> getAllPackages();
	public Map<String, Object> getPackageDetail(Integer id);
	public List<Package> getAllFilteredPackages(String activity,String interest,String destination,String maxPrice);
	public PackageDto addPackage(PackageDto packageDto);
	public void deletePackage(Integer id);
	public PackageDto updatePackage(PackageDto packageDto);
}
