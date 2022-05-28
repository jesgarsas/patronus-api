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

import com.upv.jesgarsas.patronusapi.app.model.dto.GrupoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.GrupoFilterDTO;
import com.upv.jesgarsas.patronusapi.app.service.GrupoService;

@Controller
@RequestMapping(value = "/grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@PostMapping("/alumno/all/filtered")
	public ResponseEntity<PageDTO<GrupoDTO>> findAllGruposFiltered(@RequestBody(required = true) GrupoFilterDTO filter) {
		return ResponseEntity.ok(grupoService.findAllGruposPageable(filter));
	}
	
	@DeleteMapping("/profesor/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok(grupoService.delete(id));
	}
	
	@GetMapping("/profesor/{id}")
	public ResponseEntity<GrupoDTO> findById(@PathVariable(name = "id") Integer id) {
		return ResponseEntity.ok(grupoService.findByIdDTO(id));
	}
	
	@PostMapping("/profesor/save")
	public ResponseEntity<GrupoDTO> saveOrUpdate(@RequestBody GrupoDTO dto) {
		return ResponseEntity.ok(grupoService.saveOrUpdate(dto));
	}

	@GetMapping("/alumno/autocomplete")
	public ResponseEntity<List<GrupoDTO>> getList() {
		return ResponseEntity.ok(grupoService.findAll());
	}
	
}
