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
	
	@GetMapping("/{id}")
	public ResponseEntity<PatronDTO> findById(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(patronService.findById(id));
	}
}
