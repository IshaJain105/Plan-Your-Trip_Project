package com.backend.planmytrip.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Integer id;
	private String name;
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	private String role;
}
