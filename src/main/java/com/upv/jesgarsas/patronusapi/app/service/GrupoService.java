package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.GrupoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.GrupoFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.repository.GrupoRepository;
import com.upv.jesgarsas.patronusapi.app.repository.specification.GrupoSpecification;
import com.upv.jesgarsas.patronusapi.app.service.mapper.GrupoMapper;


@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private GrupoMapper grupoMapper;
	
	public Grupo findById(Integer id) {
		return grupoRepository.findById(id).orElse(null);
	}

	public Grupo findByAlumnosId(Integer id) {
		return grupoRepository.findByAlumnosId(id);
	}
	
	public List<Grupo> findByProfesorId(Integer id) {
		return grupoRepository.findAllByProfesorId(id);
	}
	
	public GrupoDTO findByIdDTO(Integer id) {
		Grupo grupo = findById(id);
		return grupo != null ? grupoMapper.toDto(grupo) : null;
	}
	
	public PageDTO<GrupoDTO> findAllGruposPageable(GrupoFilterDTO filter) {
		Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());

		Page<Grupo> page = grupoRepository.findAll(new GrupoSpecification(filter), params);
		PageDTO<GrupoDTO> result = new PageDTO<>();
		page.getContent().forEach(patron -> {
			GrupoDTO dto = grupoMapper.toDto(patron);
			result.getContent().add(dto);
		});
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		return result;
	}

	public Boolean delete(Integer id) {
		try {
			grupoRepository.deleteById(id);
			return true;
		} catch (Exception e) {}
		return false;
	}
	
	public GrupoDTO saveOrUpdate(GrupoDTO grupoDto) {
		Grupo grupo;
		try {
			grupo = grupoMapper.toEntity(grupoDto);
			if (grupo.getId() != null) {
				Grupo grupoDB = findById(grupo.getId());
				grupo.setAlumnos(grupoDB.getAlumnos());
			}
			grupo = grupoRepository.save(grupo);
			return grupoMapper.toDto(grupo);
		} catch (Exception e) {}
		return null;
	}
}
