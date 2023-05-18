package com.prototype.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.dto.IdentificationTypesDto;
import com.prototype.mapper.IdentificationTypesMapper;
import com.prototype.repository.IdentificationTypesRepository;
import com.prototype.service.IdentificationTypesService;

@Service
@Transactional
public class IdentificationTypesImpl implements IdentificationTypesService {
	private IdentificationTypesRepository identificationTypesRepository;
	@Autowired
	public IdentificationTypesImpl(IdentificationTypesRepository identificationTypesRepository) {
		this.identificationTypesRepository = identificationTypesRepository;
	}
	@Override
	public List<IdentificationTypesDto> getIdentificationTypes() {
		return identificationTypesRepository.findAll().stream().map(IdentificationTypesMapper::mapperIdentificationTypesToIdentificationTypesDto).collect(Collectors.toList());

	}
	

}
