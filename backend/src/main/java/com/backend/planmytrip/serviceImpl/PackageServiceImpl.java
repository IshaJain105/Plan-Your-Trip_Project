package com.backend.planmytrip.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.planmytrip.dto.PackageDto;
import com.backend.planmytrip.entity.Activity;
import com.backend.planmytrip.entity.ActivityandPackage;
import com.backend.planmytrip.entity.AreaOfInterest;
import com.backend.planmytrip.entity.InterestandPackage;
import com.backend.planmytrip.entity.Package;
import com.backend.planmytrip.entity.Type;
import com.backend.planmytrip.entity.TypeandPackage;
import com.backend.planmytrip.helper.PackageDtoHelper;
import com.backend.planmytrip.repository.ActivityRepo;
import com.backend.planmytrip.repository.ActivityandPackageRepo;
import com.backend.planmytrip.repository.AreaOfInterestRepo;
import com.backend.planmytrip.repository.FlightRepo;
import com.backend.planmytrip.repository.InterestandPackageRepo;
import com.backend.planmytrip.repository.PackageRepo;
import com.backend.planmytrip.repository.TypeRepo;
import com.backend.planmytrip.repository.TypeandPackageRepo;
import com.backend.planmytrip.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired private PackageRepo packageRepo;
	@Autowired private TypeandPackageRepo typeandPackageRepo;
	@Autowired private TypeRepo typeRepo;
	@Autowired private InterestandPackageRepo interestandPackageRepo;
	@Autowired private AreaOfInterestRepo areaOfInterestRepo;
	@Autowired private ActivityandPackageRepo activityandPackageRepo;
	@Autowired private ActivityRepo activityRepo;
	@Autowired private FlightRepo flightRepo;
	@Autowired private PackageDtoHelper dtoHelper;

	@Override
	public List<Package> getAllPackages() {
		List<Package> packages = packageRepo.findAll();
		for (Package package1 : packages) {
			List<Type> types = new ArrayList<>();
			List<TypeandPackage> typeandPackages = typeandPackageRepo.findByPackageId(package1.getId());
			for (TypeandPackage typeandPackage : typeandPackages) {
				Type type = typeRepo.findById(typeandPackage.getTypeId()).get();
				types.add(type);
			}
			package1.setType(types);
		}
		
		return packages;
	}

	@Override
	public Map<String, Object> getPackageDetail(Integer id) {
		Map<String, Object> response = new HashMap<>();
		Optional<Package> package1 = packageRepo.findById(id);
		if (package1.isEmpty()) {
			response.put("error", "Package with this id: " + id + " not exist!!");
			return response;
		}

		List<Type> types = new ArrayList<>();
		List<AreaOfInterest> areaOfInterests = new ArrayList<>();
		List<Activity> activities = new ArrayList<>();

		List<TypeandPackage> typeandPackages = typeandPackageRepo.findByPackageId(package1.get().getId());
		for (TypeandPackage typeandPackage : typeandPackages) {
			types.add(typeRepo.findById(typeandPackage.getTypeId()).get());
		}
		package1.get().setType(types);

		List<InterestandPackage> interestandPackages = interestandPackageRepo.findByCityId(package1.get().getId());
		for (InterestandPackage interestandPackage : interestandPackages) {
			areaOfInterests.add(areaOfInterestRepo.findById(interestandPackage.getAreaOfInterestId()).get());
		}
		package1.get().setAreaOfInterest(areaOfInterests);

		List<ActivityandPackage> activityandPackages = activityandPackageRepo.findByCityId(package1.get().getId());
		for (ActivityandPackage activityandPackage : activityandPackages) {
			activities.add(activityRepo.findById(activityandPackage.getActivityId()).get());
		}
		package1.get().setActivities(activities);
		package1.get().setFlight(flightRepo.findByPackageId(id));

		response.put("package", package1.get());

		return response;
	}

	@Override
	public List<Package> getAllFilteredPackages(String activity, String interest, String destination, String maxPrice) {

		List<Package> packages = new ArrayList<>();

		List<InterestandPackage> interestandPackages;
		if (interest.equals("null")) {
			interestandPackages = interestandPackageRepo.findAll();
		} else {
			interestandPackages = interestandPackageRepo.findByAreaOfInterestId(Integer.valueOf(interest));
		}
		for (InterestandPackage interestandPackage : interestandPackages) {
			packages.add(packageRepo.findById(interestandPackage.getCityId()).get());
		}

		List<ActivityandPackage> activityandPackages;
		if (activity.equals("null")) {
			activityandPackages = activityandPackageRepo.findAll();
		} else {
			activityandPackages = activityandPackageRepo.findByActivityId(Integer.valueOf(activity));
		}
		for (ActivityandPackage activityandPackage : activityandPackages) {
			packages.add(packageRepo.findById(activityandPackage.getCityId()).get());
		}

		if (destination.equals("null")) {
			packages = packages.stream().distinct().collect(Collectors.toList());
		} else {
			packages = packages.stream().distinct().filter(package1 -> package1.getCityName().equals(destination) )
					.collect(Collectors.toList());
		}

		if (maxPrice.equals("null")) {
			packages = packages.stream().distinct().collect(Collectors.toList());
		} else {
			packages = packages.stream().distinct().filter(package1 -> package1.getPrice() <= Double.valueOf(maxPrice))
					.collect(Collectors.toList());
		}

		if (packages.size() == 0) {
			return new PackageServiceImpl().getAllPackages();
		}

		return packages;
	}
	
	@Override
	public PackageDto addPackage(PackageDto packageDto) {
		
		Package isPackageExist = packageRepo.findByCityName(packageDto.getCityName());
		if(isPackageExist!=null) {
			return null;
		}
		Package packageAdded  = packageRepo.save(dtoHelper.convertPackageDtoToPackage(packageDto));
		
		
		
		for(AreaOfInterest areaOfInterest:packageDto.getAreaOfInterest()) {
			AreaOfInterest findAreaOfInterest  = areaOfInterestRepo.findByName(areaOfInterest.getName());
			InterestandPackage interestandPackage = new InterestandPackage();
			interestandPackage.setAreaOfInterestId(findAreaOfInterest.getId());
			interestandPackage.setCityId(packageAdded.getId());
			interestandPackageRepo.save(interestandPackage);
		}
		for(Type type:packageDto.getType()) {
			Type findType = typeRepo.findByName(type.getName());
			TypeandPackage typeandPackage = new TypeandPackage();
			typeandPackage.setPackageId(packageAdded.getId());
			typeandPackage.setTypeId(findType.getId());
			typeandPackageRepo.save(typeandPackage);
		}
		
		for(Activity activity:packageDto.getActivities()) {
			Activity findActivity = activityRepo.findByActivityName(activity.getActivityName());
			ActivityandPackage activityandPackage = new ActivityandPackage();
			activityandPackage.setActivityId(findActivity.getId());
			activityandPackage.setCityId(packageAdded.getId());
			activityandPackageRepo.save(activityandPackage);
		}
		
		return dtoHelper.convertPackageToPackageDto(packageAdded);
	}
	
	@Override
	public void deletePackage(Integer id){
		Package p = packageRepo.findById(id).get();
		typeandPackageRepo.deleteAllByPackageId(id);
		activityandPackageRepo.deleteAllByCityId(id);
		interestandPackageRepo.deleteAllByCityId(id);
		packageRepo.delete(p);
	}

	@Override
	@Transactional
	public PackageDto updatePackage(PackageDto packageDto) {
		Optional<Package> isPackage = packageRepo.findById(packageDto.getId());
		if(isPackage.isEmpty()) {
			return null;
		}
		Package isPackageExist=isPackage.get();

		isPackageExist.setCityName(packageDto.getCityName());
		isPackageExist.setPrice(packageDto.getPrice());
		isPackageExist.setImageUrl(packageDto.getImageUrl());
		
		typeandPackageRepo.deleteAllByPackageId(isPackageExist.getId());
		interestandPackageRepo.deleteAllByCityId(isPackageExist.getId());
		activityandPackageRepo.deleteAllByCityId(isPackageExist.getId());

		for(Type type:packageDto.getType()) {
			Type findType = typeRepo.findByName(type.getName());
			TypeandPackage typeandPackage = new TypeandPackage();
			typeandPackage.setPackageId(packageDto.getId());
			typeandPackage.setTypeId(findType.getId());
			typeandPackageRepo.save(typeandPackage);
		}
		
		for(AreaOfInterest areaOfInterest:packageDto.getAreaOfInterest()) {
			AreaOfInterest findAreaOfInterest  = areaOfInterestRepo.findByName(areaOfInterest.getName());
			InterestandPackage interestandPackage = new InterestandPackage();
			interestandPackage.setAreaOfInterestId(findAreaOfInterest.getId());
			interestandPackage.setCityId(packageDto.getId());
			interestandPackageRepo.save(interestandPackage);
		}
		
		for(Activity activity:packageDto.getActivities()) {
			Activity findActivity = activityRepo.findByActivityName(activity.getActivityName());
			ActivityandPackage activityandPackage = new ActivityandPackage();
			activityandPackage.setActivityId(findActivity.getId());
			activityandPackage.setCityId(packageDto.getId());
			activityandPackageRepo.save(activityandPackage);
		}
		
		
		Package updatedPackage = packageRepo.save(isPackageExist);
		System.out.println(updatedPackage);
		return dtoHelper.convertPackageToPackageDto(updatedPackage);
	}
}