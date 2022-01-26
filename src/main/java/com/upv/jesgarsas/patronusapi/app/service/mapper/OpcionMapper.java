package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.OpcionDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Opcion;

@Mapper(componentModel = "spring")
public abstract class OpcionMapper {

	@Mappings({})
	public abstract OpcionDTO toDto(Opcion opcion);
	
	public List<OpcionDTO> toDto(Collection<Opcion> opciones) {
		return opciones.stream().map(opcion -> toDto(opcion)).collect(Collectors.toList());
	}
	
	@Mappings({@Mapping(target = "pregunta", ignore = true)})
	public abstract Opcion toEntity(OpcionDTO opcion);
	
	public Set<Opcion> toEntity(Collection<OpcionDTO> opciones) {
		return opciones.stream().map(opcion -> toEntity(opcion)).collect(Collectors.toSet());
	}
	
}
