package com.backend.planmytrip.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer userId;
	private Integer packageId;
	private Integer totalPeople;
	private Double totalPrice;
	private String name;
	private String phoneNumber;
	private String email;
	private String date;
	private String address;
	private String city;
	private String state;
	private String zip;
}
