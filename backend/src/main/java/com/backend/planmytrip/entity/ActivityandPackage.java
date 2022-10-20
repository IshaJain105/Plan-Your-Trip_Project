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
@Table(name = "activity_package")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityandPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "activity_id")
	private Integer activityId;
	
	@Column(name = "city_id")
	private Integer cityId;
}
