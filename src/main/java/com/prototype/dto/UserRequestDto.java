package com.prototype.dto;

import java.io.Serializable;

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
	private Long idIdentificationType;
	
		
	public UserRequestDto(String firstName, String lastName, String username, String email, String institution,
			Long idIdentificationType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.institution = institution;
		this.idIdentificationType = idIdentificationType;
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
	public Long getIdIdentificationType() {
		return idIdentificationType;
	}
	public void setIdIdentificationType(Long idIdentificationType) {
		this.idIdentificationType = idIdentificationType;
	}
	
	
	
}
