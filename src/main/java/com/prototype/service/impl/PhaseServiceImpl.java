package com.prototype.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.domain.Phase;
import com.prototype.domain.PhaseUser;
import com.prototype.domain.StatePhase;
import com.prototype.domain.User;
import com.prototype.dto.PhaseRequestDto;
import com.prototype.dto.PhaseResponseDto;
import com.prototype.dto.StatePhaseDto;
import com.prototype.mapper.PhaseMapper;
import com.prototype.repository.PhaseRepository;
import com.prototype.repository.PhaseUserRepository;
import com.prototype.repository.UserRepository;
import com.prototype.service.PhaseService;

@Service
@Transactional
//@Qualifier("phaseDetailsService")
public class PhaseServiceImpl implements PhaseService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private PhaseRepository phaseRepository;
    private PhaseUserRepository phaseUserRepository;
    private UserRepository userRepository;
    private PhaseMapper phaseMapper = new PhaseMapper();


    @Autowired
    public PhaseServiceImpl(PhaseRepository phaseRepository, PhaseUserRepository phaseUserRepository, UserRepository userRepository) {
        this.phaseRepository = phaseRepository;
        this.phaseUserRepository = phaseUserRepository;        
        this.userRepository = userRepository;

    }

	@Override
	public PhaseResponseDto create(PhaseRequestDto phaseRequestDto, String userTokenHeader) {
		System.out.println(phaseRequestDto.toString());
		System.out.println(userTokenHeader);
		
		Phase phase = new Phase();
		phase.setCreatedDate(new Date());
		phase.setDescription(phaseRequestDto.getDescription());
		phase.setEndDuration(phaseRequestDto.getEndDuration());
		phase.setOrdering(phaseRequestDto.getOrdering());
		phase.setPhase(phaseRequestDto.getPhase());
		phase.setStartDuration(phaseRequestDto.getStartDuration());
		phase.setStatePhase(new StatePhase(phaseRequestDto.getIdStatePhase()));
		//TODO validate than the user userTokenHeader exists in DB
		phase.setCreatedBy(userRepository.findByUsername(userTokenHeader));
		Phase phaseSaved = phaseRepository.save(phase);
		//phaseRequestDto.getUsersAsingPhase().forEach((key, value) -> userRepository.findByUsername(value));
		//TODO validate than the users of REQUETS (phaseRequestDto) exists in DB
		phaseRequestDto.getUsersAsingPhase().forEach((key, value) -> phaseUserRepository.save(new PhaseUser(new Phase(phaseSaved.getIdPhase()), new User(key))));
		return new PhaseResponseDto(phaseSaved.getIdPhase(), phaseSaved.getPhase());
	}

	@Override
	public List<Phase> getPhases() {
		List<Phase> phases = phaseRepository.findAll();
		return phases;
	}

	@Override
	public List<PhaseResponseDto> getAllPhasesDetails() {
		List<PhaseResponseDto> phasesResponse = new ArrayList<>();
		List<Phase> phases = phaseRepository.findAll();
		//TODO recorrer las fases, y sacar los usuarios asociados
		for (Phase phase : phases) {
			PhaseResponseDto phaseResponseDto = new PhaseResponseDto();
			phaseResponseDto.setCreatedBy(phaseMapper.mapperUserToUserDto(phase.getCreatedBy()));
			phaseResponseDto.setCreatedDate(phase.getCreatedDate());
			phaseResponseDto.setDescription(phase.getDescription());
			phaseResponseDto.setEndDuration(phase.getEndDuration());
			phaseResponseDto.setIdPhase(phase.getIdPhase());
			phaseResponseDto.setOrdering(phase.getOrdering());
			phaseResponseDto.setPhase(phase.getPhase());
			phaseResponseDto.setStartDuration(phase.getStartDuration());
			//TODO crear el mapper 
			phaseResponseDto.setStatePhase(new StatePhaseDto(phase.getStatePhase().getIdStatePhase(), phase.getStatePhase().getState()));
			
			//phaseUserRepository.findPhaseUserByIdPhase(phase.getIdPhase()).forEach((ph)-> System.out.println(ph.getUser().getId()));
			
			//phaseResponseDto.setUsersasignedToPhase(usersasignedToPhase);
		}
		return phasesResponse;
	}

   

}
