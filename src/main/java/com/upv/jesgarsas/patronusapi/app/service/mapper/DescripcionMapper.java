package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.upv.jesgarsas.patronusapi.app.model.dto.DescripcionDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Descripcion;

@Mapper(componentModel = "spring")
public abstract class DescripcionMapper {

	@Autowired
	protected PatronMapper patronMapper;
	
	@Autowired
	protected LocalTypesMapper localeMapper;
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "descripcion", source = "descripcion"),
		@Mapping(target = "locale", expression = "java(localeMapper.toDto(descripcion.getLocale()))")})
	public abstract DescripcionDTO toDto(Descripcion descripcion);
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "descripcion", source = "descripcion"),
		@Mapping(target = "locale", expression = "java(localeMapper.toEntity(descripcion.getLocale()))"),
		@Mapping(target = "patron", ignore = true)})
	public abstract Descripcion toEntity(DescripcionDTO descripcion);
	
	public Set<Descripcion> toSetEntity(Collection<DescripcionDTO> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
		}
		return null;
	}
	
	public Set<DescripcionDTO> toSetDto(Collection<Descripcion> descripciones) {
		if(descripciones != null && descripciones.size() > 0) {
			return descripciones.stream().map(descripcion -> toDto(descripcion)).collect(Collectors.toSet());
		}
		return null;
	}
}
