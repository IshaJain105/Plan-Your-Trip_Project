package com.backend.planmytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.planmytrip.entity.Type;
import com.backend.planmytrip.service.TypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/type")
public class TypeController {

	@Autowired private TypeService service;
	
	@GetMapping("/get-all-types")
	public List<Type> getAllTypes(){
		return service.getAllTypes();
	}
}
