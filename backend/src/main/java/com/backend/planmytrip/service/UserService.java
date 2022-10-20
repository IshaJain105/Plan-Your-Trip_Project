package com.backend.planmytrip.service;

import com.backend.planmytrip.dto.UserDto;

public interface UserService {
	public UserDto login(UserDto userDto);
	public UserDto register(UserDto userDto);
}
