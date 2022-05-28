package com.upv.jesgarsas.patronusapi.app.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas.EstadisticasEjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;

@Mapper(componentModel = "spring")
public abstract class EstadisticasEjercicioMapper {

	@Mappings({@Mapping(target = "grupos", ignore = true), @Mapping(target = "preguntas", ignore = true), @Mapping(target = "numeroPreguntas", ignore = true)})
	public abstract EstadisticasEjercicioDTO toDto(Ejercicio ejercicio);
}
