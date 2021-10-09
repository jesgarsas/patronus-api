package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.PatronDTO;
import com.upv.jesgarsas.patronusapi.app.service.PatronService;

@Controller
@RequestMapping(value = "/patron")
public class PatronController {

	@Autowired
	private PatronService patronService;
	
	@GetMapping("/all")
	public ResponseEntity<List<PatronDTO>> findAllPatrones() {
		return ResponseEntity.ok(patronService.findAllPatrones());
	}
	
	@GetMapping("/all/{idLocale}")
	public ResponseEntity<List<PatronDTO>> findAllPatrones(@PathVariable(name = "idLocale", required = true) Integer idLocale) {
		return ResponseEntity.ok(patronService.findAllPatronesByLocale(idLocale));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PatronDTO> findById(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(patronService.findById(id));
	}
	
	@GetMapping("/{idPatron}/{idLocale}")
	public ResponseEntity<PatronDTO> findByIdAndLocale(@PathVariable(name = "idPatron", required = true) Integer id,
			@PathVariable(name = "idLocale", required = true) Integer idLocale) {
		return ResponseEntity.ok(patronService.findByIdAndLocale(id, idLocale));
	}
}
