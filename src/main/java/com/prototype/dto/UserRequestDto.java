package com.prototype.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequestDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String  lastName;
	private String  username;
	private String  email;
	private String  institution;
	private IdentificationTypesDto identificationType;
	private String currentUsername;
	@JsonIgnore
	private MultipartFile profileImage;
	private boolean active;
	private boolean isNonLocked;
	private String role;
	
	


	public UserRequestDto(String firstName, String lastName, String username, String email, String institution,
			IdentificationTypesDto identificationType, String currentUsername, MultipartFile profileImage,
			boolean active, boolean isNonLocked, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.institution = institution;
		this.identificationType = identificationType;
		this.currentUsername = currentUsername;
		this.profileImage = profileImage;
		this.active = active;
		this.isNonLocked = isNonLocked;
		this.role = role;
	}

	public UserRequestDto() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	

	public IdentificationTypesDto getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypesDto identificationType) {
		this.identificationType = identificationType;
	}

	public String getCurrentUsername() {
		return currentUsername;
	}

	public void setCurrentUsername(String currentUsername) {
		this.currentUsername = currentUsername;
	}

	public MultipartFile getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isNonLocked() {
		return isNonLocked;
	}

	public void setNonLocked(boolean isNonLocked) {
		this.isNonLocked = isNonLocked;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
		

	
	
}
