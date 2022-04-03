package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upv.jesgarsas.patronusapi.app.model.dto.EjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.EjercicioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;
import com.upv.jesgarsas.patronusapi.app.model.entity.Pregunta;
import com.upv.jesgarsas.patronusapi.app.repository.EjercicioRepository;
import com.upv.jesgarsas.patronusapi.app.repository.OpcionRepository;
import com.upv.jesgarsas.patronusapi.app.repository.PatronRepository;
import com.upv.jesgarsas.patronusapi.app.repository.PreguntaRepository;
import com.upv.jesgarsas.patronusapi.app.repository.UsuarioRepository;
import com.upv.jesgarsas.patronusapi.app.repository.specification.EjercicioSpecifiction;
import com.upv.jesgarsas.patronusapi.app.service.mapper.EjercicioMapper;

@Service
@Transactional
public class EjercicioService {

	@Autowired
	private EjercicioRepository ejercicioRepository;
	
	@Autowired
	private EjercicioMapper ejercicioMapper;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PatronRepository patronRepository;

	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private OpcionRepository opcionRepository;
	
	/**
	 * Return a page filtered and ordened by column with a determined size
	 * @param filter dto with params
	 * @return page
	 */
	public PageDTO<EjercicioDTO> findAllPatronesPageable(EjercicioFilterDTO filter) {
		Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());
		Page<Ejercicio> page = ejercicioRepository.findAll(new EjercicioSpecifiction(filter), params);
		PageDTO<EjercicioDTO> result = new PageDTO<>();
		result.setContent(ejercicioMapper.toDto(page.getContent()));
		result.setTotalElements(page.getTotalElements());
		result.setTotalPages(page.getTotalPages());
		return result;
	}

	public List<EjercicioDTO> findByPatron(Integer id, Integer idUser) {
		if (id == null || idUser == null) {
			return null;
		}
		return ejercicioMapper.toDtoTablePatron(ejercicioRepository.findAllByPatronAndUsuario(id, idUser));
	}

	@Transactional
	public Integer saveOrUpdate(EjercicioDTO dto) {
		Ejercicio ejercicio = ejercicioMapper.toEntity(dto);
		ejercicio.setAutor(usuarioRepository.findByIdWithoutPassword(dto.getIdAutor()));
		ejercicio.setPatron(patronRepository.findById(dto.getPatron().getId()).orElseThrow(() -> new RuntimeException("Mandatory un patron")));
		deletePreguntas(ejercicio);
		if (ejercicio.getPreguntas() != null) {
			ejercicio.getPreguntas().forEach(pregunta -> {
				pregunta.setEjercicio(ejercicio);
				deleteOpciones(pregunta);
				if (pregunta.getOpciones() != null) {
					pregunta.getOpciones().forEach(opcion -> {
						opcion.setPregunta(pregunta);
					});
				}
			});
		}
		
		this.ejercicioRepository.save(ejercicio);
		return dto.getPatron().getId();
	}
	
	private void deleteOpciones(Pregunta pregunta) {
		if (pregunta.getId() != null) {
			opcionRepository.deleteByPreguntaId(pregunta.getId());
		}
	}

	private void deletePreguntas(Ejercicio ejercicio) {
		if (ejercicio.getId() != null) {
			preguntaRepository.deleteByEjercicioId(ejercicio.getId());
		}
	}

	@Transactional
	public void deleteById(Integer id) {
		this.ejercicioRepository.deleteById(id);
	}
	
	public EjercicioDTO findById(Integer id) {
		return this.ejercicioMapper.toDto(ejercicioRepository.getOne(id));
	}
}
