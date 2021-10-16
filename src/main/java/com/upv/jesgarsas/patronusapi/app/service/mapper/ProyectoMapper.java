package com.upv.jesgarsas.patronusapi.app.service.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.web.multipart.MultipartFile;

import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Proyecto;

@Mapper(componentModel = "spring")
public abstract class ProyectoMapper {
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "name", source = "name"),
		@Mapping(target = "size", source = "size"),
		@Mapping(target = "type", source = "type"),
		@Mapping(target = "link", ignore = true)})
	public abstract ProyectoDTO toDto(Proyecto proyecto);
	
	@Mappings({@Mapping(target = "id", source = "id"),
		@Mapping(target = "name", source = "name"),
		@Mapping(target = "size", source = "size"),
		@Mapping(target = "type", source = "type"),
		@Mapping(target = "archivo", ignore = true),
		@Mapping(target = "patron", ignore = true)})
	public abstract Proyecto toEntity(ProyectoDTO proyecto);
	
	@Mappings({@Mapping(target = "name", source = "originalFilename"),
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "size", source = "size"),
		@Mapping(target = "type", source = "contentType"),
		@Mapping(target = "archivo", source = "bytes"),
		@Mapping(target = "patron", ignore = true)})
	public abstract Proyecto toEntity(MultipartFile file) throws Exception;
	
	public List<ProyectoDTO> toListDto(Collection<Proyecto> proyectos) {
		if(proyectos != null && proyectos.size() > 0) {
			return proyectos.stream().map(proyecto -> toDto(proyecto)).collect(Collectors.toList());
		}
		return null;
	}
	
	public Set<Proyecto> toSetEntity(Collection<ProyectoDTO> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toSet());
		}
		return null;
	}
	
	public Set<Proyecto> toSetEntityFromFile(Collection<MultipartFile> dtos) {
		if(dtos != null && dtos.size() > 0) {
			return dtos.stream().map(dto -> {
				try {
					return toEntity(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}).collect(Collectors.toSet());
		}
		return null;
	}
}
