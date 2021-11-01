package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.repository.GrupoRepository;


@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public Grupo findById(Integer id) {
		return grupoRepository.findById(id).orElse(null);
	}

	public Grupo findByAlumnosId(Integer id) {
		return grupoRepository.findByAlumnosId(id);
	}
	
	public List<Grupo> findByProfesorId(Integer id) {
		return grupoRepository.findAllByProfesorId(id);
	}
}
