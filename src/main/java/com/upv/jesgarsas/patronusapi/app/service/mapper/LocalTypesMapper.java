package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.upv.jesgarsas.patronusapi.app.model.dto.LocalTypesDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.LocalTypes;

@Mapper(componentModel = "spring")
public abstract class LocalTypesMapper {

	@Mappings({@Mapping(target = "id", source = "id"),
			@Mapping(target = "code", source = "code")})
	public abstract LocalTypesDTO toDto(LocalTypes type);
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "code", source = "code")})
	public abstract LocalTypes toEntity(LocalTypesDTO type);
	
	public List<LocalTypesDTO> toListDto(Collection<LocalTypes> types) {
		return types.stream().map(type -> toDto(type)).collect(Collectors.toList());
	}
	
	public List<LocalTypes> toListEntity(Collection<LocalTypesDTO> types) {
		return types.stream().map(type -> toEntity(type)).collect(Collectors.toList());
	}
}
