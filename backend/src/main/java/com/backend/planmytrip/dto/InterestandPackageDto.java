package com.backend.planmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestandPackageDto {
	private Integer id;
	private Integer areaOfInterestId;
	private Integer cityId;
}
