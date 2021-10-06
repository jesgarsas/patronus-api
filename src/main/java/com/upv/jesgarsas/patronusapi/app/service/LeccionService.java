package com.upv.jesgarsas.patronusapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.LeccionDTO;
import com.upv.jesgarsas.patronusapi.app.repository.LeccionRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.LeccionMapper;

@Service
public class LeccionService {

	@Autowired
	private LeccionMapper leccionMapper;
	
	@Autowired
	private LeccionRepository leccionRepository;
	
	public LeccionDTO findByPatronAndLocale(Integer idPatron, Integer idLocale) {
		if(idLocale != null && idLocale != null) {
			return leccionMapper.toDto(leccionRepository.findByPatronIdAndLocaleId(idPatron, idLocale));
		}
		return null;
	}
}
