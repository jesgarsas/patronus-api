package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.PatronDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.repository.PatronRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.PatronMapper;

@Service
public class PatronService {
	
	@Autowired
	private PatronRepository patronRepository;
	
	@Autowired
	private PatronMapper patronMapper;
	
	public List<PatronDTO> findAllPatrones() {
		return patronMapper.toListDto(patronRepository.findAll());
	}
	
	public PatronDTO findById(Integer id) {
		if(id != null) {
			return patronMapper.toDto(patronRepository.findById(id).orElse(new Patron()));
		}
		return null;
	}
}
