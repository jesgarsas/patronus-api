package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.LocalTypesDTO;
import com.upv.jesgarsas.patronusapi.app.repository.LocalTypesRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.LocalTypesMapper;

@Service
public class LocalTypesService {
	
	@Autowired
	private LocalTypesRepository localTypesRepository;
	
	@Autowired
	private LocalTypesMapper localTypesMapper;
	
	public List<LocalTypesDTO> findAll() {
		return localTypesMapper.toListDto(localTypesRepository.findAll());
	}
	
	public LocalTypesDTO findById(Integer id) {
		return localTypesMapper.toDto(localTypesRepository.findById(id));
	}
}
