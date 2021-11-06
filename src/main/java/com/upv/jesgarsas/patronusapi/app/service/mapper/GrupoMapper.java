package com.upv.jesgarsas.patronusapi.app.service.mapper;

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
		@Mapping(target = "alumnosCount", expression = "java(grupo.getAlumnos().size())"),
		@Mapping(target = "profesor", expression = "java(usuarioMapper.toDto(grupo.getProfesor()))"),
	})
	public abstract GrupoDTO toDto(Grupo grupo);
}
