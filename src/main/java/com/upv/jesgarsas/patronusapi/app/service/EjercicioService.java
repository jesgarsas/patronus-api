package com.upv.jesgarsas.patronusapi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.EjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.EjercicioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;
import com.upv.jesgarsas.patronusapi.app.repository.EjercicioRepository;
import com.upv.jesgarsas.patronusapi.app.repository.specification.EjercicioSpecifiction;

@Service
public class EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	public PageDTO<EjercicioDTO> findAllPatronesPageable(EjercicioFilterDTO filter) {
		Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());

		Page<Ejercicio> page = ejercicioRepository.findAll(new EjercicioSpecifiction(filter), params);
		PageDTO<EjercicioDTO> result = new PageDTO<>();
//		page.getContent().forEach(patron -> { 
//			patron.getDescripciones();
//			PatronDTO dto = patronMapper.toDto(patron);
//			result.getContent().add(dto);
//		});
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		return result;
	}
}
