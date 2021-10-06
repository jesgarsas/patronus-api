package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.service.ProyectoService;

@Controller
@RequestMapping(value = "/proyecto")
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping(value = "/{idPatron}")
	public ResponseEntity<List<ProyectoDTO>> findByPatron(@PathVariable(name = "idPatron", required = true) Integer idPatron) {
		return ResponseEntity.ok(proyectoService.findByPatron(idPatron));
	}
	
	@GetMapping(value = "/download/{id}")
	public ResponseEntity<ProyectoDTO> findById(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(proyectoService.findById(id));
	}
}
