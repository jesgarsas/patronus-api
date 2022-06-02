package com.upv.jesgarsas.patronusapi.app.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.HomeEstadisticasDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.LastEjercicioDTO;
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
	
	@GetMapping("/profesor/estadisticas/ejercicio/{idEjercicio}")
	public ResponseEntity<Object> getEstadisticas(@PathVariable(required = true, value = "idEjercicio") Integer idEjercicio,
			@PathParam(value = "idGrupos") Integer[] idGrupos) throws Exception {
		if (idGrupos == null) {
			throw new Exception("Se ha de seleccionar almenos un grupo");
		}
		return ResponseEntity.ok(resultadoService.getEstadisticas(idEjercicio, idGrupos));
	}
	
	@GetMapping("/alumno/ultimo/")
	public ResponseEntity<LastEjercicioDTO> getUltimoEjercicio() {
		return ResponseEntity.ok(resultadoService.getLastEjercicio());
	}
	
	@GetMapping("/alumno/estadisticas/")
	public ResponseEntity<HomeEstadisticasDTO> getEjerciciosResueltosEstat() {
		return ResponseEntity.ok(resultadoService.getEjerciciosResueltosEstat());
	}
}
