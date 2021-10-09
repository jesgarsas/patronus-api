package com.upv.jesgarsas.patronusapi.app.service.mapper;

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
}
