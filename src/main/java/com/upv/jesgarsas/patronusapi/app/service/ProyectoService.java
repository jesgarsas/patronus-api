package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Proyecto;
import com.upv.jesgarsas.patronusapi.app.repository.ProyectoRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.ProyectoMapper;

@Service
public class ProyectoService {
	
	@Autowired
	private ProyectoMapper proyectoMapper;
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public List<ProyectoDTO> findByPatron(Integer idPatron) {
		return proyectoMapper.toListDto(proyectoRepository.findAllByPatronId(idPatron));
	}
	
	public ProyectoDTO findById(Integer id) {
		Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
		if(proyecto != null) {
			return proyectoMapper.toDto(proyecto);
		}
		return null;
	}
}
