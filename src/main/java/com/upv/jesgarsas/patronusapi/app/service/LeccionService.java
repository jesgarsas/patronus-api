package com.upv.jesgarsas.patronusapi.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.LeccionDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Leccion;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.repository.LeccionRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.LeccionMapper;

@Service
public class LeccionService {

	@Autowired
	private LeccionMapper leccionMapper;
	
	@Autowired
	private LeccionRepository leccionRepository;
	
	public Set<LeccionDTO> findByPatronAndLocale(Integer idPatron, Integer idLocale) {
		if(idLocale != null && idLocale != null) {
			return leccionMapper.toSetDto(leccionRepository.findAllByPatronIdAndLocaleId(idPatron, idLocale));
		}
		return null;
	}

	public void save(LeccionDTO lecDTO, Patron patron) {
		Leccion lec = leccionMapper.toEntity(lecDTO);
		lec.setPatron(patron);
		leccionRepository.save(lec);
		
	}
}
