package com.prototype.mapper;



import com.prototype.domain.User;
import com.prototype.dto.UserDto;
import com.prototype.dto.UserRequestDto;
import com.prototype.enumeration.Role;

public class UserMapper {
	
	public static UserDto mapperUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setActive(user.isActive());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setInstitution(user.getInstitution());
		userDto.setLastName(user.getLastName());
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		return userDto;
	}
	
}
