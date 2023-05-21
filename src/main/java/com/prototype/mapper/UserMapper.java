package com.prototype.mapper;



import com.prototype.domain.User;
import com.prototype.dto.UserDto;

public class UserMapper {
	
	public static UserDto mapperUserToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setIdUser(user.getIdUser());
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
