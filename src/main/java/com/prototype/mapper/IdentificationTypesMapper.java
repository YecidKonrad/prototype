package com.prototype.mapper;

import com.prototype.domain.IdentificationTypes;
import com.prototype.dto.IdentificationTypesDto;

public class IdentificationTypesMapper {
	
	public static IdentificationTypesDto mapperIdentificationTypesToIdentificationTypesDto(IdentificationTypes identificationTypes) {
		IdentificationTypesDto identificationTypesDto = new IdentificationTypesDto();
		identificationTypesDto.setIdentification(identificationTypes.getIdentification());
		identificationTypesDto.setIdIdentificationType(identificationTypes.getIdIdentificationType());
		identificationTypesDto.setName(identificationTypes.getName());
		return identificationTypesDto;
	}

}
