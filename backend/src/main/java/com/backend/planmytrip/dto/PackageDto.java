package com.backend.planmytrip.dto;

import java.util.List;

import com.backend.planmytrip.entity.Activity;
import com.backend.planmytrip.entity.AreaOfInterest;
import com.backend.planmytrip.entity.Flight;
import com.backend.planmytrip.entity.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDto {

	private Integer id;
	private String cityName;
	private Double price;
	private String imageUrl;
	private List<Type> type;
	private List<AreaOfInterest> areaOfInterest;
	private List<Activity> activities;
	private Flight flight;
}
