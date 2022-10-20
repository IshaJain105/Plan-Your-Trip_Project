package com.backend.planmytrip.dto;


import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private Integer id;
	private Integer userId;
	private Integer packageId;
	private Integer totalPeople;
	private Double totalPrice;
	private String name;
	private String phoneNumber;
	@Email
	private String email;
	private String date;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	
}
