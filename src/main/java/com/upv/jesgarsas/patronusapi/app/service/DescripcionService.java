package com.upv.jesgarsas.patronusapi.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.DescripcionDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Descripcion;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.repository.DescripcionRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.DescripcionMapper;

@Service
public class DescripcionService {

	@Autowired
	private DescripcionRepository descripcionRepository;
	
	@Autowired
	private DescripcionMapper descripcionMapper;
	
	public Set<DescripcionDTO> findByPatronAndLocale(Integer idPatron, Integer idLocale) {
		return descripcionMapper.toSetDto(descripcionRepository.findAllByPatronIdAndLocaleId(idPatron, idLocale));
	}
	
	public void save(DescripcionDTO descDTO, Patron patron) {
		Descripcion desc = descripcionMapper.toEntity(descDTO);
		desc.setPatron(patron);
		descripcionRepository.save(desc);
	}
}
