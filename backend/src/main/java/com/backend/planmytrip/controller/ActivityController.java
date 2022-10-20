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

import com.backend.planmytrip.dto.ActivityDto;
import com.backend.planmytrip.entity.Activity;
import com.backend.planmytrip.service.ActivityService;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/activities")
public class ActivityController {

	@Autowired private ActivityService activityService;
	
	@GetMapping("/get-all-activities")
	public List<Activity> getAllActivities(){
		return activityService.getAllActivities();
	}
	
	@PostMapping("/addActivity")
	@Transactional
	public ResponseEntity<Map<String, Object>> addActivity(@RequestBody ActivityDto activityDto){
		Map<String, Object> response = new HashMap<>();
		
		ActivityDto activityAdded = activityService.addActivity(activityDto);

		if(activityAdded==null) {
			response.put("error", "Activity already exist!!");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		response.put("activity", activityAdded);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
}