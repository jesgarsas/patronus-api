package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.EjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;

@Mapper(componentModel = "spring")
public abstract class EjercicioMapper {
	
	@Autowired
	protected PreguntaMapper preguntaMapper;
	
	@Autowired
	protected LocalTypesMapper localMapper;
	
	@Autowired
	protected PatronMapper patronMapper;

	@Mappings({ @Mapping(target = "numPreguntas", expression = "java(ejercicio.getPreguntas() != null ? ejercicio.getPreguntas().size() : 0)"),
		@Mapping(target = "nombreAutor", source = "autor.nick"), @Mapping(target = "idAutor", ignore = true),
		@Mapping(target = "patron", expression = "java(patronMapper.toDto(ejercicio.getPatron()))"), @Mapping(target = "locale", expression = "java(localMapper.toDto(ejercicio.getLocale()))")})
	public abstract EjercicioDTO toDtoTable(Ejercicio ejercicio);
	
	public List<EjercicioDTO> toDtoTable(Collection<Ejercicio> ejercicios) {
		return ejercicios.stream().map(ejercicio -> toDtoTable(ejercicio)).collect(Collectors.toList());
	}
	
	@Mappings({ @Mapping(target = "numPreguntas", expression = "java(ejercicio.getPreguntas() != null ? ejercicio.getPreguntas().size() : 0)"),
		@Mapping(target = "nombreAutor", source = "autor.nick"), @Mapping(target = "idAutor", source = "autor.id"),
		@Mapping(target = "locale", expression = "java(localMapper.toDto(ejercicio.getLocale()))"),
		@Mapping(target = "patron", expression = "java(patronMapper.toDto(ejercicio.getPatron()))"),
		@Mapping(target = "preguntas", expression = "java(preguntaMapper.toDto(ejercicio.getPreguntas()))")})
	public abstract EjercicioDTO toDto(Ejercicio ejercicio);
	
	public List<EjercicioDTO> toDto(Collection<Ejercicio> ejercicios) {
		return ejercicios.stream().map(ejercicio -> toDtoTable(ejercicio)).collect(Collectors.toList());
	}
	
	@Mappings({ @Mapping(target = "autor", ignore = true), @Mapping(target = "patron", ignore = true),
		@Mapping(target = "locale", expression = "java(localMapper.toEntity(ejercicio.getLocale()))"),
		@Mapping(target = "preguntas", expression = "java(preguntaMapper.toEntity(ejercicio.getPreguntas()))")})
	public abstract Ejercicio toEntity(EjercicioDTO ejercicio);
}
