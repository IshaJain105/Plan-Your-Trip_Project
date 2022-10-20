package com.backend.planmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityandPackageDto {

	private Integer id;
	private Integer activityId;
	private Integer cityId;
}
