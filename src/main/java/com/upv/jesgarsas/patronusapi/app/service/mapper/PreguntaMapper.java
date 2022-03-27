package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.PreguntaDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Pregunta;

@Mapper(componentModel = "spring")
public abstract class PreguntaMapper {
	
	@Autowired
	protected OpcionMapper opcionMapper;
	
	@Mappings({@Mapping(target = "opciones", expression = "java(opcionMapper.toDto(pregunta.getOpciones()))")})
	public abstract PreguntaDTO toDto(Pregunta pregunta); 
	
	public List<PreguntaDTO> toDto(Collection<Pregunta> preguntas) {
		return preguntas.stream().map(pregunta -> toDto(pregunta)).collect(Collectors.toList());
	}
	
	@Mappings({@Mapping(target = "ejercicio", ignore = true), @Mapping(target = "opciones", 
			expression = "java(opcionMapper.toEntity(pregunta.getOpciones()))")})
	public abstract Pregunta toEntity(PreguntaDTO pregunta); 
	
	public Set<Pregunta> toEntity(Collection<PreguntaDTO> preguntas) {
		return preguntas.stream().map(pregunta -> toEntity(pregunta)).collect(Collectors.toSet());
	}
}
