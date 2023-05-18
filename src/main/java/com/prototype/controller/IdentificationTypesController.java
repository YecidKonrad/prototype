package com.prototype.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.exception.ExceptionHandling;
import com.prototype.service.IdentificationTypesService;
import com.prototype.utility.JWTTokenProvider;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/identifications-types" })
public class IdentificationTypesController extends ExceptionHandling{
	private IdentificationTypesService identificationTypesService;

	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	public IdentificationTypesController(IdentificationTypesService identificationTypesService, JWTTokenProvider jwtTokenProvider) {
		this.identificationTypesService = identificationTypesService;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@GetMapping("/types")
	public ResponseEntity<?> getIdentificationTypes() {
		return new ResponseEntity<>(identificationTypesService.getIdentificationTypes(), OK);
	}

}
