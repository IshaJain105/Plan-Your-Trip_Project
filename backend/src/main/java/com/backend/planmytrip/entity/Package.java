package com.backend.planmytrip.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cityName;
	private Double price;
	private String imageUrl;
	
	@Transient
	private List<Type> type;
	
	@Transient
	private List<AreaOfInterest> areaOfInterest;
	
	@Transient
	private List<Activity> activities;
	
	@Transient 
	private Flight flight;
}
