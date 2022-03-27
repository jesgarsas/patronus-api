package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<PageDTO<EjercicioDTO>> findAllPatronesFiltered(@RequestBody(required = true) EjercicioFilterDTO filter) {
		return ResponseEntity.ok(ejercicioService.findAllPatronesPageable(filter));
	}
	
	@GetMapping("/alumno/patron/{id}/usuario/{usuario}")
	public ResponseEntity<List<EjercicioDTO>> findEjerciciosByPatron(@PathVariable(name = "id", required = true) Integer id, 
			@PathVariable(name = "usuario", required = true) Integer idUser) {
		return ResponseEntity.ok(ejercicioService.findByPatron(id, idUser));
	}
	
	@PostMapping("/profesor/save")
	public ResponseEntity<Integer> saveEjercicio(@RequestBody(required = true) EjercicioDTO dto) {
		return ResponseEntity.ok(this.ejercicioService.saveOrUpdate(dto));
	}
	
	@DeleteMapping("/profesor/delete/{id}")
	public ResponseEntity<Boolean> saveEjercicio(@PathVariable(name = "id", required = true) Integer id) {
		this.ejercicioService.deleteById(id);
		return ResponseEntity.ok(true);
	}
}
