package com.prototype.controller;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dto.PhaseRequestDto;
import com.prototype.dto.PhaseResponseDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.service.PhaseService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@RequestMapping(path = { "/phase" })
public class PhaseController extends ExceptionHandling {
	private PhaseService phaseService;

	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public PhaseController(PhaseService phaseService, JWTTokenProvider jwtTokenProvider) {
		this.phaseService = phaseService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@GetMapping("/json")
	public ResponseEntity<PhaseRequestDto> generate(){
		PhaseRequestDto phaseRequestDto = new PhaseRequestDto();
		Map<Long, String> doubleBraceMap  = new HashMap<Long, String>() {{
		    put(1L, "value1");
		    put(2L, "value2");
		}};
		phaseRequestDto.setUsersAsingPhase(doubleBraceMap);
		phaseRequestDto.setStartDuration(new Date());
		phaseRequestDto.setEndDuration(new Date());
		return new ResponseEntity<>(phaseRequestDto, OK);
	}

	@PostMapping("/create")
	public ResponseEntity<PhaseResponseDto> create(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody PhaseRequestDto phaseRequest) {
		PhaseResponseDto responsePhase = phaseService.create(phaseRequest, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(responsePhase, OK);
	}
	
	@GetMapping("/phases")
	public ResponseEntity<?> getPhases(){	
		return new ResponseEntity<>(phaseService.getPhases(), OK);
	}
	
	//TODO getPhasesbyId
	

}
