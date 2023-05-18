package com.prototype.dto;

import java.io.Serializable;

public class IdentificationTypesDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idIdentificationType;
	private String identification;
	private String name;
	
	public IdentificationTypesDto(Long idIdentificationType, String identification, String name) {
		this.idIdentificationType = idIdentificationType;
		this.identification = identification;
		this.name = name;
	}

	public IdentificationTypesDto() {
	}

	public Long getIdIdentificationType() {
		return idIdentificationType;
	}

	public void setIdIdentificationType(Long idIdentificationType) {
		this.idIdentificationType = idIdentificationType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
