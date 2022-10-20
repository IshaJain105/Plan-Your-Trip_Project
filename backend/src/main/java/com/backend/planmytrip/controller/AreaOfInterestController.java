package com.backend.planmytrip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.planmytrip.dto.AreaOfInterestDto;
import com.backend.planmytrip.entity.AreaOfInterest;
import com.backend.planmytrip.service.AreaOfInterestService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/area-of-interest")
public class AreaOfInterestController {

	@Autowired private AreaOfInterestService areaOfInterestService;
	
	@GetMapping("/get-all-area-of-interest")
	public List<AreaOfInterest> getAllAreaOfInterest(){
		return areaOfInterestService.getAllOfAreaOfInterest();
	}
	
	@PostMapping("/addInterests")
	@Transactional
	public ResponseEntity<Map<String, Object>> addInterest(@RequestBody AreaOfInterestDto interestDto){
		Map<String, Object> response = new HashMap<>();
		
		AreaOfInterestDto interestAdded = areaOfInterestService.addInterest(interestDto);

		if(interestAdded==null) {
			response.put("error", "Area of Interest already exist!!");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		response.put("interest", interestAdded);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
