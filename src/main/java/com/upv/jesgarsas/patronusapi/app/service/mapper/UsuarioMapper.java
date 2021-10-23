package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
	
	@Mappings({@Mapping(target = "id", expression = "java(usuario.getId())"),
		@Mapping(target = "email", expression = "java(usuario.getEmail())"),
		@Mapping(target = "rolId", expression = "java(usuario.getRolId())"),
		@Mapping(target = "nick", expression = "java(usuario.getNick())"),
		@Mapping(target = "password", expression = "java(usuario.getPassword())"),
		@Mapping(target = "lastPatron", expression = "java(usuario.getLastPatron())"),
		@Mapping(target = "token", ignore = true)})
	public abstract UsuarioDTO toDto(Usuario usuario);
	
	@Mappings({@Mapping(target = "id", expression = "java(usuario.getId())"),
		@Mapping(target = "email", expression = "java(usuario.getEmail())"),
		@Mapping(target = "rolId", expression = "java(usuario.getRolId())"),
		@Mapping(target = "nick", expression = "java(usuario.getNick())"),
		@Mapping(target = "password", expression = "java(usuario.getPassword())"),
		@Mapping(target = "lastPatron", expression = "java(usuario.getLastPatron())")})
	public abstract Usuario toEntity(UsuarioDTO usuario);
	
	public List<UsuarioDTO> toListDto(Collection<Usuario> usuarios) {
		if(usuarios != null && usuarios.size() > 0) {
			return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
		}
		return null;
	}
	
	public Set<Usuario> toSetEntity(Collection<UsuarioDTO> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
		}
		return null;
	}
}
