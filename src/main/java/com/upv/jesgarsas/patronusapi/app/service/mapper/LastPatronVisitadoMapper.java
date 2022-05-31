package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.LastPatronVisitadoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.LastPatronVisitado;

@Mapper(componentModel = "spring")
public abstract class LastPatronVisitadoMapper {

	@Mappings({
		@Mapping(target = "idUsuario", source="id.idUsuario"),
		@Mapping(target = "idPatron", source="id.idPatron"),
	})
	public abstract LastPatronVisitadoDTO toDto(LastPatronVisitado e);
	
	public List<LastPatronVisitadoDTO> toDto(List<LastPatronVisitado> e) {
		return e.stream().map(i -> toDto(i)).collect(Collectors.toList());
	}
	
}
