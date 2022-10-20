package com.backend.planmytrip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interest_package")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InterestandPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "area_of_interest_id")
	private Integer areaOfInterestId;
	
	@Column(name = "city_id")
	private Integer cityId;
}
