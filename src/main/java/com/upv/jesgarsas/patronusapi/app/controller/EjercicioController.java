package com.upv.jesgarsas.patronusapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.EjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.EjercicioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.service.EjercicioService;

@Controller
@RequestMapping(value = "/ejercicio")
public class EjercicioController {

	@Autowired
	private EjercicioService ejercicioService;
	
	@PostMapping("/profesor/all/filtered")
	public ResponseEntity<PageDTO<EjercicioDTO>> findAllGruposFiltered(@RequestBody(required = true) EjercicioFilterDTO filter) {
		return ResponseEntity.ok(ejercicioService.findAllPatronesPageable(filter));
	}
}
