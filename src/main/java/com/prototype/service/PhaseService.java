package com.prototype.service;

import java.util.List;

import com.prototype.domain.Phase;
import com.prototype.dto.PhaseRequestDto;
import com.prototype.dto.PhaseResponseDto;

public interface PhaseService {

    PhaseResponseDto create(PhaseRequestDto phaseRequestDto, String userTokenHeder);
    List<Phase> getPhases();
    List<PhaseResponseDto> getAllPhasesDetails();

   
}
