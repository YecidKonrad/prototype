package com.prototype.mapper;

import com.prototype.domain.Phase;
import com.prototype.dto.PhaseDto;
import com.prototype.dto.StatePhaseDto;

public  class PhaseMapper {	
	
	public static PhaseDto mapperPhaseToPhaseDto(Phase phase) {
		PhaseDto phaseDto = new PhaseDto();
		phaseDto.setCreatedBy(UserMapper.mapperUserToUserDto(phase.getCreatedBy()));
		phaseDto.setCreatedDate(phase.getCreatedDate());
		phaseDto.setDescription(phase.getDescription());
		phaseDto.setEndDuration(phase.getEndDuration());
		phaseDto.setIdPhase(phase.getIdPhase());
		phaseDto.setOrdering(phase.getOrdering());
		phaseDto.setPhase(phase.getPhase());
		phaseDto.setStartDuration(phase.getStartDuration());
		phaseDto.setStatePhase(new StatePhaseDto(phase.getStatePhase().getIdStatePhase(), phase.getStatePhase().getState()));		
		return phaseDto;
	}

}
