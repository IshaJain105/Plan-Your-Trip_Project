package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.TypeDto;
import com.backend.planmytrip.entity.Type;

@Component
public class TypeDtoHelper {

	public Type convertTypeDtoToType(TypeDto dto) {
		Type type = new Type();
		BeanUtils.copyProperties(dto, type);
		return type;
	}
	
	public TypeDto convertTypeToTypeDto(Type type) {
		TypeDto dto = new TypeDto();
		BeanUtils.copyProperties(type, dto);
		return dto;
	}
}
