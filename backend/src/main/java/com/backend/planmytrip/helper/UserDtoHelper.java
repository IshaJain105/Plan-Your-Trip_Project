package com.backend.planmytrip.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.backend.planmytrip.dto.UserDto;
import com.backend.planmytrip.entity.User;

@Component
public class UserDtoHelper {

	public UserDto convertUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
	
	public User convertUserDtoToUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}
}
