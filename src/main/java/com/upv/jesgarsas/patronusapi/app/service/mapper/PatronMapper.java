package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.PatronDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;

@Mapper(componentModel = "spring")
public abstract class PatronMapper {
	
	@Autowired
	protected AutorMapper autorMapper;
	
	@Autowired
	protected DescripcionMapper descripcionMapper;
	
	@Autowired
	protected LeccionMapper leccionMapper;

	@Mappings({@Mapping(target = "id", expression = "java(patron.getId())"),
		@Mapping(target = "nombre", expression = "java(patron.getNombre())"),
		@Mapping(target = "fechaCreacion", expression = "java(patron.getFechaCreacion())"),
		@Mapping(target = "autor", expression = "java(autorMapper.toDto(patron.getAutor()))"),
		@Mapping(target = "descripciones", expression = "java(descripcionMapper.toSetDto(patron.getDescripciones()))"),
		@Mapping(target = "lecciones", ignore = true),
		@Mapping(target = "proyectos", ignore = true),
		@Mapping(target = "leccionesCount", expression = "java(patron.getLecciones() != null ? patron.getLecciones().size() : 0)"),
		@Mapping(target = "proyectosCount", expression = "java(patron.getProyectos() != null ? patron.getProyectos().size() : 0)")})
	public abstract PatronDTO toDto(Patron patron);
	
	@Mappings({@Mapping(target = "id", expression = "java(patron.getId())"),
		@Mapping(target = "nombre", expression = "java(patron.getNombre())"),
		@Mapping(target = "fechaCreacion", expression = "java(patron.getFechaCreacion())"),
		@Mapping(target = "autor", ignore = true),
		@Mapping(target = "descripciones", ignore = true),
		@Mapping(target = "lecciones", ignore = true),
		@Mapping(target = "proyectos", ignore = true)})
	public abstract Patron toEntity(PatronDTO patron);
	
	public List<PatronDTO> toListDto(Collection<Patron> patron) {
		if(patron != null && patron.size() > 0) {
			return patron.stream().map(user -> toDto(user)).collect(Collectors.toList());
		}
		return null;
	}
	
	public Set<Patron> toSetEntity(Collection<PatronDTO> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
		}
		return null;
	}
}
