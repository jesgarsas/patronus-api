package com.upv.jesgarsas.patronusapi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
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
		List<ProyectoDTO> proyectos = proyectoMapper.toListDto(proyectoRepository.findAllByPatronId(idPatron));
		return proyectos == null ? new ArrayList<ProyectoDTO>() : proyectos;
	}
	
	public List<Proyecto> findByPatron(Patron patron) {
		return proyectoRepository.findAllByPatronId(patron.getId());
	}
	
	public ProyectoDTO findById(Integer id) {
		Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
		if(proyecto != null) {
			return proyectoMapper.toDto(proyecto);
		}
		return null;
	}
	
	public void save(Proyecto proyecto, Patron patron) {
		proyecto.setPatron(patron);
		proyectoRepository.save(proyecto);
	}
	
	public void delete(Proyecto proyecto) {
		proyectoRepository.delete(proyecto);
	}
}
