package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.LeccionDTO;
import com.upv.jesgarsas.patronusapi.app.service.LeccionService;

@Controller
@RequestMapping(value = "/leccion")
public class LeccionController {

	@Autowired
	private LeccionService leccionService;
	
	@GetMapping("/alumno/{idPatron}/{idLocale}")
	public ResponseEntity<Set<LeccionDTO>> findByPatronAndLocale(@PathVariable(name = "idPatron", required = true) Integer idPatron,
			@PathVariable(name = "idLocale", required = true) Integer idLocale) {
		return ResponseEntity.ok(leccionService.findByPatronAndLocale(idPatron, idLocale));
	}
}
