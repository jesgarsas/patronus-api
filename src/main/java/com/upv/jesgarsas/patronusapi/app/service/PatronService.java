package com.upv.jesgarsas.patronusapi.app.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.upv.jesgarsas.patronusapi.app.model.dto.PagePatronDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PatronDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PatronFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.model.entity.Proyecto;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;
import com.upv.jesgarsas.patronusapi.app.repository.PatronRepository;
import com.upv.jesgarsas.patronusapi.app.repository.UsuarioRepository;
import com.upv.jesgarsas.patronusapi.app.repository.specification.PatronSpecification;
import com.upv.jesgarsas.patronusapi.app.service.mapper.PatronMapper;
import com.upv.jesgarsas.patronusapi.app.service.mapper.ProyectoMapper;


@Service
public class PatronService {

	@Autowired
	private PatronRepository patronRepository;

	@Autowired
	private PatronMapper patronMapper;

	@Autowired
	private ProyectoMapper proyectoMapper;

	@Autowired
	private DescripcionService descripcionService;

	@Autowired
	private LeccionService leccionService;

	@Autowired
	private ProyectoService proyectoService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<PatronDTO> findAllPatrones() {
		return patronMapper.toListDto(patronRepository.findAll());
	}
	
	public PagePatronDTO findAllPatronesPageable(PatronFilterDTO filter) {
		Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());

		Page<Patron> page = patronRepository.findAll(new PatronSpecification(filter), params);
		PagePatronDTO result = new PagePatronDTO();
		page.getContent().forEach(patron -> { 
			patron.getDescripciones();
			PatronDTO dto = patronMapper.toDto(patron);
			result.getPatrones().add(dto);
		});
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		return result;
	}

	public List<PatronDTO> findAllPatronesByLocale(Integer idLocale) {
		List<PatronDTO> patrones = patronMapper.toListDto(patronRepository.findAll());
		if (patrones != null) {
			patrones.forEach(patron -> {
				patron.setDescripciones(descripcionService.findByPatronAndLocale(patron.getId(), idLocale));
				patron.setLecciones(leccionService.findByPatronAndLocale(patron.getId(), idLocale));
				patron.setProyectos(proyectoService.findByPatron(patron.getId()));
			});
		}

		return patrones;
	}

	public PatronDTO findById(Integer id) {
		if (id != null) {
			return patronMapper.toDto(patronRepository.findById(id).orElse(new Patron()));
		}
		return null;
	}

	public PatronDTO findByIdAndLocale(Integer id, Integer idLocale) {
		PatronDTO patron = patronMapper.toDto(patronRepository.findById(id).orElse(new Patron()));
		if (patron.getId() != null) {
			patron.setDescripciones(descripcionService.findByPatronAndLocale(patron.getId(), idLocale));
			patron.setLecciones(leccionService.findByPatronAndLocale(id, idLocale));
			patron.setProyectos(proyectoService.findByPatron(id));
		}
		return patron;
	}

	@Transactional
	public void deleteById(Integer id) {
		// Limpiar todos los usuarios que tengan el patron
		usuarioRepository.updateLastPatronToNull(id);
		patronRepository.deleteById(id);
		return;
	}

	@Transactional
	public PatronDTO saveOrUpdate(PatronDTO dto, List<MultipartFile> files) {
		Patron patron = patronMapper.toEntity(dto);
		// Set de autor
		Usuario autor = usuarioRepository.findById(dto.getAutor().getId()).orElse(null);
		if (autor != null) {
			patron.setAutor(autor);
		}
		Patron _patron = patronRepository.save(patron);
		// Set relaciones
		dto.getDescripciones().forEach(desc -> {
			descripcionService.save(desc, _patron);
		});
		dto.getLecciones().forEach(lec -> {
			leccionService.save(lec, _patron);
		});
		// Guardado de documentos
		if(patron.getId() != null) {
			List<Integer> idsOldDocs = dto.getProyectos().stream().map(proyecto -> proyecto.getId()).collect(Collectors.toList());
			List<Proyecto> oldProyectos = proyectoService.findByPatron(patron);
			boolean borrar = true;
			for (Proyecto oldProyecto : oldProyectos) {
				for (Integer id : idsOldDocs) {
					if (oldProyecto.getId().equals(id)) {
						borrar = false;
						break;
					}
				}
				if (borrar) {
					proyectoService.delete(oldProyecto);
				}
			}
		}
		if (!CollectionUtils.isEmpty(files)) {
			Set<Proyecto> proyectos = proyectoMapper.toSetEntityFromFile(files);
			for (Proyecto proyecto : proyectos) {
				if (proyecto != null) {
					proyectoService.save(proyecto, _patron);
				}
			}
		}
		return patronMapper.toDto(patron);
	}
}