package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

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
import com.upv.jesgarsas.patronusapi.app.service.mapper.EjercicioMapper;

@Service
public class EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Autowired
	private EjercicioMapper ejercicioMapper;
	
	/**
	 * Return a page filtered and ordened by column with a determined size
	 * @param filter dto with params
	 * @return page
	 */
	public PageDTO<EjercicioDTO> findAllPatronesPageable(EjercicioFilterDTO filter) {
		Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());
		Page<Ejercicio> page = ejercicioRepository.findAll(new EjercicioSpecifiction(filter), params);
		PageDTO<EjercicioDTO> result = new PageDTO<>();
		result.setContent(ejercicioMapper.toDto(page.getContent()));
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		return result;
	}

	public List<EjercicioDTO> findByPatron(Integer id, Integer idUser) {
		if (id == null || idUser == null) {
			return null;
		}
		return ejercicioMapper.toDtoTable(ejercicioRepository.findAllByPatronAndUsuario(id, idUser));
	}
}
