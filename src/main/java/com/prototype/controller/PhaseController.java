package com.prototype.controller;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.prototype.dto.PhaseDto;
import com.prototype.dto.PhaseRequestDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.service.PhaseService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = {JWT_TOKEN_HEADER})
@RequestMapping(path = { "/phase" })
public class PhaseController extends ExceptionHandling {
	private PhaseService phaseService;

	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public PhaseController(PhaseService phaseService, JWTTokenProvider jwtTokenProvider) {
		this.phaseService = phaseService;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@GetMapping("/states")
	public ResponseEntity<?> getPhasesStates() {
		return new ResponseEntity<>(phaseService.getPhasesStates(), OK);
	}

	@PostMapping("/create")
	public ResponseEntity<PhaseDto> create(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader,
			@RequestBody PhaseRequestDto phaseRequest) {
		JsonMapper mapper = new JsonMapper();
		try {
			System.out.println(mapper.writeValueAsString(phaseRequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PhaseDto responsePhase = phaseService.create(phaseRequest, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(responsePhase, OK);
	}

	// TODO solicitar Token getPhases
	@GetMapping("/phasesDetails")
	public ResponseEntity<?> getPhasesDetails() {
		return new ResponseEntity<>(phaseService.getAllPhasesDetails(), OK);
	}
	
	@GetMapping("/phases")
	public ResponseEntity<?> getPhases() {
		return new ResponseEntity<>(phaseService.getAllPhasesDetails(), OK);
	}
	
	@GetMapping("/phase/{idPhase}")
	public ResponseEntity<?> getPhases(@PathVariable Long idPhase) {
		return new ResponseEntity<>(phaseService.getPhase(idPhase), OK);
	}
	
	@GetMapping("/phaseDetails/{idPhase}")
	public ResponseEntity<?> getPhasesDetail(@PathVariable Long idPhase) {
		return new ResponseEntity<>(phaseService.getPhaseDetail(idPhase), OK);
	}
	
	@DeleteMapping("/deletePhase/{idPhase}")
	public ResponseEntity<?> deletePhase(@PathVariable Long idPhase) {
		return new ResponseEntity<>(phaseService.deletePhase(idPhase), OK);
	}

	@PostMapping("/update")
	public ResponseEntity<PhaseDto> update(@RequestBody PhaseRequestDto phaseRequest) {
		return new ResponseEntity<>(phaseService.update(phaseRequest), OK);
	}
	
	@GetMapping("/usersAssinged/{idPhase}")
	public ResponseEntity<?> addUsersAssinged(@PathVariable Long idPhase) {
		return new ResponseEntity<>(phaseService.usersAssinged(idPhase), OK);
	}
	
	@GetMapping("/activitiesAssinged/{idPhase}")
	public ResponseEntity<?> addActivitiesAssinged(@PathVariable Long idPhase) {
		return new ResponseEntity<>(phaseService.usersAssinged(idPhase), OK);
	}


}
