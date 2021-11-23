package com.upv.jesgarsas.patronusapi.app.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.AutorDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;

@Mapper(componentModel = "spring")
public abstract class AutorMapper {

	@Mappings({@Mapping(target = "id", expression = "java(usuario.getId())"),
		@Mapping(target = "nick", expression = "java(usuario.getNick())")})
	public abstract AutorDTO toDto(Usuario usuario); 
	
	@Mappings({@Mapping(target = "id", expression = "java(usuario.getId())"),
		@Mapping(target = "nick", expression = "java(usuario.getNick())"),
		@Mapping(target = "email", ignore = true),
		@Mapping(target = "rolId", ignore = true),
		@Mapping(target = "password", ignore = true),
		@Mapping(target = "lastPatron", ignore = true),
		@Mapping(target = "grupo", ignore = true)})
	public abstract Usuario toEntity(AutorDTO usuario); 
}
