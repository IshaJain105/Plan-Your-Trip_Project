package com.backend.planmytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

	private Integer id;
	private String activityName;
	private Double activityPrice;
}
