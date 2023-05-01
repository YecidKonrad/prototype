package com.prototype.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.prototype.domain.Activity;
import com.prototype.domain.ActivityPhase;
import com.prototype.domain.Phase;
import com.prototype.domain.PhaseUser;
import com.prototype.domain.StatePhase;
import com.prototype.domain.User;
import com.prototype.dto.ActivityDto;
import com.prototype.dto.PhaseDto;
import com.prototype.dto.PhaseRequestDto;
import com.prototype.dto.UserDto;
import com.prototype.mapper.PhaseMapper;
import com.prototype.mapper.UserMapper;
import com.prototype.repository.PhaseActivityRepository;
import com.prototype.repository.PhaseRepository;
import com.prototype.repository.PhaseUserRepository;
import com.prototype.repository.UserRepository;
import com.prototype.service.PhaseService;

@Service
@Transactional
public class PhaseServiceImpl implements PhaseService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private PhaseRepository phaseRepository;
	private PhaseUserRepository phaseUserRepository;
	private UserRepository userRepository;
	private ActivityServiceImpl activityServiceImpl;
	private PhaseActivityRepository phaseActivityRepository;
	JsonMapper mapper = new JsonMapper();

	@Autowired
	public PhaseServiceImpl(PhaseRepository phaseRepository, PhaseUserRepository phaseUserRepository,
			UserRepository userRepository, ActivityServiceImpl activityServiceImpl, PhaseActivityRepository phaseActivityRepository) {
		this.phaseRepository = phaseRepository;
		this.phaseUserRepository = phaseUserRepository;
		this.userRepository = userRepository;
		this.activityServiceImpl = activityServiceImpl;
		this.phaseActivityRepository = phaseActivityRepository;

	}

	@Override
	public PhaseDto create(PhaseRequestDto phaseRequestDto, String userTokenHeader) {
		Phase phase = new Phase();
		phase.setCreatedBy(userRepository.findByUsername(userTokenHeader));
		phase.setCreatedDate(new Date());
		phase.setDescription(phaseRequestDto.getDescription());
		phase.setEndDuration(phaseRequestDto.getEndDuration());
		phase.setOrdering(phaseRequestDto.getOrdering());
		phase.setPhase(phaseRequestDto.getPhase());
		phase.setStartDuration(phaseRequestDto.getStartDuration());
		phase.setStatePhase(new StatePhase(phaseRequestDto.getIdStatePhase()));
		Phase phaseSaved = phaseRepository.save(phase);
		// TODO validate than the users of REQUETS (phaseRequestDto) exists in DB
		phaseRequestDto.getUsersAsingPhase().forEach((key, value) -> phaseUserRepository.save(new PhaseUser(new Phase(phaseSaved.getIdPhase()), new User(key))));
		phaseRequestDto.getActivitiesAsingPhase().forEach(acitivity -> {
		ActivityDto activitySaved = activityServiceImpl.create(acitivity, userTokenHeader);
		phaseActivityRepository.save(new ActivityPhase(new Activity(activitySaved.getIdActivity()), new Phase(phaseSaved.getIdPhase())));
		});
		return new PhaseDto(phaseSaved.getIdPhase(), phaseSaved.getPhase());
	}

	@Override
	public Set<Phase> getPhases() {
		Set<Phase> phases = new HashSet<>(phaseRepository.findAll());
		return phases;
	}

	@Override
	public List<PhaseDto> getAllPhasesDetails() {
		List<PhaseDto> phasesResponse = new ArrayList<>();
		List<Phase> phases = phaseRepository.findAll();
		for (Phase phase : phases) {
			PhaseDto phaseResponseDto = PhaseMapper.mapperPhaseToPhaseDto(phase);
			List<UserDto> usersAsignedToPhase = findPhaseUserByPhase(phase.getIdPhase());
			phaseResponseDto.setUsersAsignedToPhase(usersAsignedToPhase);
			phasesResponse.add(phaseResponseDto);
		}
		return phasesResponse;
	}

	@Override
	public Optional<Phase> getPhase(Long idPhase) {
		return phaseRepository.findById(idPhase);
	}

	@Override
	public PhaseDto getPhaseDetail(Long idPhase) {
		Phase phase = phaseRepository.findById(idPhase).orElse(null);
		PhaseDto phaseResponseDto = PhaseMapper.mapperPhaseToPhaseDto(phase);
		phaseResponseDto.setUsersAsignedToPhase(findPhaseUserByPhase(phase.getIdPhase()));
		return phaseResponseDto;
	}


	@Override
	public PhaseDto update(PhaseRequestDto phaseRequestDto, Long idPhase) {
		//TODO validar que cada campo no venga nullo y sea el mismo guardado
		Optional<Phase> phase = getPhase(idPhase);
		if (phase.get() != null) {
			phase.get().setDescription(phaseRequestDto.getDescription());
			phase.get().setEndDuration(phase.get().getEndDuration());
			phase.get().setIdPhase(idPhase);
			phase.get().setOrdering(phaseRequestDto.getOrdering());
			phase.get().setPhase(phaseRequestDto.getPhase());
			phase.get().setStartDuration(phaseRequestDto.getStartDuration());
			phase.get().setStatePhase(new StatePhase(phaseRequestDto.getIdStatePhase()));
			phaseRepository.save(phase.get());
			return PhaseMapper.mapperPhaseToPhaseDto(phase.get());
		}
		return PhaseMapper.mapperPhaseToPhaseDto(phase.get());
		
	}

	@Override
	// TODO controllar la exception si no existe la phase a eliminar
	public Map<String, String> deletePhase(Long idPhase) {
		Map<String, String> response = new HashMap<String, String>();
		if (getPhase(idPhase).get() != null) {
			phaseUserRepository.deleteByPhase(new Phase(idPhase));
			phaseRepository.delete(new Phase(idPhase));
			response.put("SUCCES", String.format("PHASE ID : %s DELETED", idPhase));
			return response;
		}
		response.put("ERROR", String.format("PHASE ID : %s NOT_FOUND", idPhase));
		return response;
	}

	@Override
	public List<UserDto> usersAssinged(Long idPhase) {
		return findPhaseUserByPhase(idPhase);
	}

	@Override
	public List<UserDto> assingUser(Map<String,String> usersAsingPhase, Long idPhase) {
		System.out.println("Lego al servicie");
		usersAsingPhase.forEach((k,v) -> System.out.println(" k " + k + " " + " v "+ v));
		if (getPhase(idPhase) != null) {
			List<PhaseUser> usersAssingneds = phaseUserRepository.findPhaseUserByPhase(new Phase(idPhase));
			for (PhaseUser phaseUser : usersAssingneds) {
				usersAsingPhase.forEach((k,v)->{
					if (!phaseUser.getUser().getUsername().equalsIgnoreCase(v)) {
						phaseUserRepository.save(new PhaseUser(new Phase(idPhase), new User(Long.parseLong(k))));
					}			
					});
				return findPhaseUserByPhase(idPhase);
				
				
				
			}
		}
		return findPhaseUserByPhase(idPhase);
	}

	// AUXILIAR METHOD
	public List<UserDto> findPhaseUserByPhase(Long idPhase) {
		List<UserDto> usersAsignedToPhase = new ArrayList<>();
		phaseUserRepository.findPhaseUserByPhase(new Phase(idPhase)).forEach((ph) -> {
			User userAsigned = userRepository.findByUsername(ph.getUser().getUsername());
			usersAsignedToPhase.add(UserMapper.mapperUserToUserDto(userAsigned));
		});
		return usersAsignedToPhase;
	}
	


}
