package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.LastPatronVisitadoDTO;
import com.upv.jesgarsas.patronusapi.app.service.LastPatronVisitadoService;

@Controller
@RequestMapping(value = "/visitado")
public class LastPatronVisitadoController {

	@Autowired
	private LastPatronVisitadoService lastPatronVisitadoService;
	
	@PostMapping("/alumno/{id}")
	public ResponseEntity<Boolean> visitedPatron(@PathVariable(name = "id", required = true) Integer id) {
		lastPatronVisitadoService.save(id);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping("/alumno/get/{id}")
	public ResponseEntity<List<LastPatronVisitadoDTO>> getPatronesVisitados(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(lastPatronVisitadoService.findAll());
	}
}
