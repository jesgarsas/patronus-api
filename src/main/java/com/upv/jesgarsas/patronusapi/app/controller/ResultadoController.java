package com.upv.jesgarsas.patronusapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.ResultadoDTO;
import com.upv.jesgarsas.patronusapi.app.service.ResultadoService;

@Controller
@RequestMapping(value = "/resultado")
public class ResultadoController {
	
	@Autowired
	private ResultadoService resultadoService;

	@PostMapping("/alumno/save")
	public ResponseEntity<Boolean> saveResultado(@RequestBody(required = true) ResultadoDTO dto) {
		resultadoService.save(dto);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping("/alumno/checkIntentos/{idEjercicio}")
	public ResponseEntity<Boolean> checkIntentos(@PathVariable(required = true, value = "idEjercicio") Integer idEjercicio) {
		return ResponseEntity.ok(resultadoService.canUsuarioHacerEjercicio(idEjercicio));
	}
}
