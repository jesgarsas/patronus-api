package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.GrupoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;

@Mapper(componentModel = "spring")
public abstract class GrupoMapper {
	
	@Autowired
	protected UsuarioMapper usuarioMapper;
	
	@Mappings({
		@Mapping(target = "id", source = "id"),
		@Mapping(target = "nombre", source = "nombre"),
		@Mapping(target = "label", ignore = true),
		@Mapping(target = "alumnosCount", expression = "java(grupo.getAlumnos().size())"),
		@Mapping(target = "profesor", expression = "java(usuarioMapper.toDto(grupo.getProfesor()))"),
	})
	public abstract GrupoDTO toDto(Grupo grupo);
	
	@Mappings({
		@Mapping(target = "id", source = "id"),
		@Mapping(target = "label", expression = "java(grupo.getId() + \" - \" + grupo.getNombre())"),
		@Mapping(target = "alumnosCount", expression = "java(grupo.getAlumnos().size())"),
		@Mapping(target = "profesor", expression = "java(usuarioMapper.toDto(grupo.getProfesor()))"),
	})
	public abstract GrupoDTO toDtoAutocomplete(Grupo grupo);
	
	public List<GrupoDTO> toDto(List<Grupo> grupos) {
		return grupos.stream().map(grupo -> toDto(grupo)).collect(Collectors.toList());
	}
	
	public List<GrupoDTO> toDtoAutocomplete(List<Grupo> grupos) {
		return grupos.stream().map(grupo -> toDtoAutocomplete(grupo)).collect(Collectors.toList());
	}
	
	@Mappings({
		@Mapping(target = "id", source = "id"),
		@Mapping(target = "nombre", source = "nombre"),
		@Mapping(target = "alumnos", ignore = true),
		@Mapping(target = "profesor", expression = "java(usuarioMapper.toEntity(grupo.getProfesor()))"),
	})
	public abstract Grupo toEntity(GrupoDTO grupo);
}
