package com.prototype.mapper;

import com.prototype.domain.User;
import com.prototype.dto.UserDto;

public class UserMapper {
	
	public static UserDto convertUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setActive(user.isActive());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setInstitution(user.getInstitution());
		userDto.setLastName(user.getInstitution());
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

}
