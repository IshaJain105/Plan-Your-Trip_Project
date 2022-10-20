package com.backend.planmytrip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.planmytrip.entity.Type;
import com.backend.planmytrip.repository.TypeRepo;
import com.backend.planmytrip.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired private TypeRepo repo;
	
	@Override
	public List<Type> getAllTypes(){
		return repo.findAll();
	}
}
