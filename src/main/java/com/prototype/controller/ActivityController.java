package com.prototype.controller;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dto.ActivityRequestDto;
import com.prototype.dto.ActivityDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.service.ActivityService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@RequestMapping(path = { "/activity" })
public class ActivityController extends ExceptionHandling {
	
	private ActivityService activityService;

	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public ActivityController(ActivityService activityService, JWTTokenProvider jwtTokenProvider) {
		this.activityService = activityService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@GetMapping("/json")
	public ResponseEntity<ActivityRequestDto> generate(){
		return new ResponseEntity<>(new ActivityRequestDto(), OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ActivityDto> create(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody ActivityRequestDto activityRequestDto) {
		ActivityDto activityResponseDto = activityService.create(activityRequestDto, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(activityResponseDto, OK);
	}
	
	@GetMapping("/activities")
	public ResponseEntity<?> getActivities(){
		return new ResponseEntity<>(activityService.getActivities(), OK);
	}
	//TODO obtener detalle de actividades
	//TODO obtener actividad Detalle por ID
	//TODO obtener actividad por ID
	//TODO modificar actividad
	//TODO agregar usuarios a una actividad
	//TODO agregar fases a una actividad
	//TODO modificar fases de una actividad
	//TODO eliminar fases de un actividad


}
