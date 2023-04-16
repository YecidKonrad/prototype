package com.prototype.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.prototype.domain.Phase;
import com.prototype.dto.PhaseDto;
import com.prototype.dto.PhaseRequestDto;
import com.prototype.dto.UserDto;

public interface PhaseService {

    PhaseDto create(PhaseRequestDto phaseRequestDto, String userTokenHeder);
    Set<Phase> getPhases();
    List<PhaseDto> getAllPhasesDetails();
    Optional<Phase> getPhase(Long idPhase);
    PhaseDto getPhaseDetail(Long idPhase);
    Map<String,String> deletePhase(Long idPhase);
    PhaseDto update(PhaseRequestDto phaseRequestDto, Long idPhase);
    List<UserDto> usersAssinged(Long idPhase);
	List<UserDto> assingUser(Map<String,String> usersAsingPhase, Long idPhase);
    

   
}
