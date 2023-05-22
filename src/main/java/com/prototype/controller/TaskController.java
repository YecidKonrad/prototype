package com.prototype.controller;

import static com.prototype.constant.SecurityConstant.JWT_TOKEN_HEADER;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.dto.StateTaskDto;
import com.prototype.dto.TaskDto;
import com.prototype.exception.ExceptionHandling;
import com.prototype.service.TaskService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = {JWT_TOKEN_HEADER})
@RequestMapping(path = { "/task" })
public class TaskController extends ExceptionHandling {
	
	private TaskService taskService;
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public TaskController(TaskService taskService, JWTTokenProvider jwtTokenProvider) {
		this.taskService = taskService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@GetMapping("/json")
	public ResponseEntity<TaskDto> generate(){
		return new ResponseEntity<>(new TaskDto(), OK);
	}

	@PostMapping("/create")
	public ResponseEntity<TaskDto> create(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody TaskDto taskRequestDto) {
		TaskDto taskDtoResponseDto = taskService.create(taskRequestDto, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(taskDtoResponseDto, OK);
	}
	@PostMapping("/update")
	public ResponseEntity<TaskDto> update(@RequestHeader(JWT_TOKEN_HEADER) String tokenHeader, @RequestBody TaskDto taskRequestDto) {
		TaskDto taskResponseDto = taskService.update(taskRequestDto, jwtTokenProvider.getSubject(tokenHeader));
		return new ResponseEntity<>(taskResponseDto, OK);
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDto>> getTasks(){
		return new ResponseEntity<>(taskService.getAllTaskDetails(), OK);
	}
	
	@GetMapping("/states")
	public ResponseEntity<List<StateTaskDto>> getTaskStates() {
		return new ResponseEntity<>(taskService.getStatesTask(), OK);
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
