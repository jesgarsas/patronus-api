package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.LocalTypesDTO;
import com.upv.jesgarsas.patronusapi.app.service.LocalTypesService;

@Controller
@RequestMapping(value = "/local-types")
public class LocalTypesController {
	
	@Autowired
	private LocalTypesService localTypesService;
	
	@GetMapping("/all")
	public ResponseEntity<List<LocalTypesDTO>> findAll() {
		return ResponseEntity.ok(localTypesService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocalTypesDTO> findById(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(localTypesService.findById(id));
	}
}
