package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.LeccionDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Leccion;

@Mapper(componentModel = "spring")
public abstract class LeccionMapper {

	@Autowired
	protected LocalTypesMapper localMapper;
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "contenido", source = "contenido"),
		@Mapping(target = "locale", expression = "java(localMapper.toDto(leccion.getLocale()))")})
	public abstract LeccionDTO toDto(Leccion leccion);
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "contenido", source = "contenido"),
		@Mapping(target = "locale", expression = "java(localMapper.toEntity(leccion.getLocale()))"),
		@Mapping(target = "patron", ignore = true)})
	public abstract Leccion toEntity(LeccionDTO leccion);
	
	public List<LeccionDTO> toListDto(Collection<Leccion> lecciones) {
		if(lecciones != null && lecciones.size() > 0) {
			return lecciones.stream().map(leccion -> toDto(leccion)).collect(Collectors.toList());
		}
		return null;
	}
	
	public Set<LeccionDTO> toSetDto(Collection<Leccion> lecciones) {
		if(lecciones != null && lecciones.size() > 0) {
			return lecciones.stream().map(leccion -> toDto(leccion)).collect(Collectors.toSet());
		}
		return null;
	}
	
	public Set<Leccion> toSetEntity(Collection<LeccionDTO> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
		}
		return null;
	}
}
