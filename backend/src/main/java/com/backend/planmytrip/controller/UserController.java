package com.backend.planmytrip.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.planmytrip.dto.UserDto;
import com.backend.planmytrip.service.UserService;

@RestController

@CrossOrigin(origins = "*")

@RequestMapping("/user")
public class UserController {


	@Autowired private UserService service;

	
	@PostMapping("/login")
	
	public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody UserDto userDto, BindingResult result){
		Map<String, Object> response = new HashMap<>();
		//data validations - email and password must be in correct format and required
		if(result.hasErrors()) {
			result.getAllErrors().forEach((error)->{
				String fieldName = ((FieldError)error).getField();
				String errorMessage = ((FieldError)error).getDefaultMessage();
				response.put(fieldName,errorMessage);
			});
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		UserDto loginUser = service.login(userDto);
		//if user not found with this email and password
		if(loginUser==null) {
			response.put("error", "Please enter correct credentials!!");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		// if user is found with this email and password
		response.put("user", loginUser);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody UserDto userDto, BindingResult result){
		Map<String, Object> response = new HashMap<>();
		//data validations - email, password and role must be in correct format and required
		if(result.hasErrors()) {
			result.getAllErrors().forEach((error)->{
				String fieldName = ((FieldError)error).getField();
				String errorMessage = ((FieldError)error).getDefaultMessage();
				response.put(fieldName,errorMessage);
			});
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		UserDto registeredUser = service.register(userDto);
		// if user with email is already exist
		if(registeredUser==null) {
			response.put("error", "User with this email already exist!!");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		// register new user
		response.put("user", registeredUser);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
}
