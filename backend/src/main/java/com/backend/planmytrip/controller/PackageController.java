package com.backend.planmytrip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.planmytrip.dto.PackageDto;
import com.backend.planmytrip.entity.Package;
import com.backend.planmytrip.service.PackageService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/package")
public class PackageController {

	@Autowired private PackageService packageService;
	
	@GetMapping("/get-all-packages")
	public List<Package> getAllPackages() {
		return packageService.getAllPackages();
	}

	@GetMapping("/package-detail/{id}")
	public ResponseEntity<Map<String, Object>> getPackageDetail(@PathVariable Integer id) {
		Map<String, Object> response = packageService.getPackageDetail(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/filter/get-all-packages")
	public List<Package> getAllFilteredPackages(@RequestParam(required = false) String activity,
			@RequestParam(required = false) String interest, @RequestParam(required = false) String destination,
			@RequestParam(required = false) String maxPrice) {
		return packageService.getAllFilteredPackages(activity, interest, destination, maxPrice);
	}

	// add package
	@PostMapping("/addPackage")
	public ResponseEntity<Map<String, Object>> addPackage(@RequestBody PackageDto packageDto) {
		Map<String, Object> response = new HashMap<>();

		PackageDto packageAdded = packageService.addPackage(packageDto);

		if (packageAdded == null) {
			response.put("error", "Package already exist!!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("package", packageAdded);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// update package
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updatePackage(@RequestBody PackageDto packageDto ){
		System.out.print(packageDto);
		Map<String, Object> response = new HashMap<>();
		PackageDto updatedPackage = packageService.updatePackage(packageDto);
		if(updatedPackage == null) {
			response.put("error", "Package not exist!!");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("package", updatedPackage);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// delete package
	@DeleteMapping("/delete/{id}")
	@Transactional
	public ResponseEntity<Map<String, Boolean>> deletePackage(@PathVariable Integer id) {
		packageService.deletePackage(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}