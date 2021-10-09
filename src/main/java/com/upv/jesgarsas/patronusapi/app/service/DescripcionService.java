package com.upv.jesgarsas.patronusapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.DescripcionDTO;
import com.upv.jesgarsas.patronusapi.app.repository.DescripcionRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.DescripcionMapper;

@Service
public class DescripcionService {

	@Autowired
	private DescripcionRepository descripcionRepository;
	
	@Autowired
	private DescripcionMapper descripcionMapper;
	
	public DescripcionDTO findByPatronAndLocale(Integer idPatron, Integer idLocale) {
		return descripcionMapper.toDto(descripcionRepository.findByPatronIdAndLocaleId(idPatron, idLocale));
	}
}
