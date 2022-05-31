package com.upv.jesgarsas.patronusapi.app.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.LastPatronVisitadoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.LastPatronVisitado;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.model.entity.pk.LastPatronVisitadoPK;
import com.upv.jesgarsas.patronusapi.app.repository.LastPatronVisitadoRepository;
import com.upv.jesgarsas.patronusapi.app.repository.PatronRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.LastPatronVisitadoMapper;

@Service
public class LastPatronVisitadoService {

	public static final int MAX_PATRONES = 3;
	
	private static final Logger LOG = LoggerFactory.getLogger(JWTService.class);
	
	@Autowired
	private LastPatronVisitadoRepository lastPatronVisitadoRepository;
	
	@Autowired
	private PatronRepository patronRepository;
	
	@Autowired
	private LastPatronVisitadoMapper lastPatronVisitadoMapper;
	
	@Transactional
	public void save(Integer patronId) {
		Integer idUser = -1;
		try {
			idUser = Integer.valueOf(((SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1]).getAuthority());
		} catch (Exception e) {
			LOG.error("User doesn't have ID");
			return;
		}
		List<LastPatronVisitado> visitados = this.lastPatronVisitadoRepository.findByIdIdUsuarioOrderByFechaDesc(idUser);
		LastPatronVisitado newEntry = new LastPatronVisitado(new LastPatronVisitadoPK(idUser, patronId), Timestamp.from(Instant.now())); 
		if (visitados.contains(newEntry)) {
			this.lastPatronVisitadoRepository.delete(visitados.get(visitados.indexOf(newEntry)));
			this.lastPatronVisitadoRepository.save(newEntry);
			return;
		}
		
		if (visitados.size() >= MAX_PATRONES) {
			this.lastPatronVisitadoRepository.delete(visitados.get(visitados.size() - 1));
		}
		
		this.lastPatronVisitadoRepository.save(newEntry);
	}
	
	public List<LastPatronVisitadoDTO> findAll() {
		Integer idUser = -1;
		try {
			idUser = Integer.valueOf(((SimpleGrantedAuthority) SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1]).getAuthority());
		} catch (Exception e) {
			LOG.error("User doesn't have ID");
			return new ArrayList<>();
		}
		List<LastPatronVisitadoDTO> dto = lastPatronVisitadoMapper.toDto(this.lastPatronVisitadoRepository.findByIdIdUsuarioOrderByFechaDesc(idUser));
		dto.forEach(patronDTO -> {
			Patron patron = patronRepository.getOne(patronDTO.getIdPatron());
			patronDTO.setName(patron != null ? patron.getNombre() : "Sin título");
		});
		return dto;
	}
}
