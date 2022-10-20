package com.backend.planmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeandPackageDto {
	private Integer id;
	private Integer typeId;
	private Integer packageId;
}
