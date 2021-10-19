package com.upv.jesgarsas.patronusapi.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Proyecto;
import com.upv.jesgarsas.patronusapi.app.service.ProyectoService;

@Controller
@RequestMapping(value = "/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoService proyectoService;

	@GetMapping(value = "/{idPatron}")
	public ResponseEntity<List<ProyectoDTO>> findByPatron(
			@PathVariable(name = "idPatron", required = true) Integer idPatron) {
		return ResponseEntity.ok(proyectoService.findByPatron(idPatron));
	}

	@GetMapping(value = "/download/{id}")
	public ResponseEntity<InputStreamResource> findById(@PathVariable(name = "id", required = true) Integer id)
			throws Exception {

		Proyecto proyecto = proyectoService.findByIdEntity(id);
		File file = proyectoService.getFileById(proyecto);
		if (file != null) {
			InputStreamResource in;
			try {
				in = new InputStreamResource(new FileInputStream(file));
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + proyecto.getName())
						.contentLength(file.length()) //
						.body(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("El id proporcionado no esta vinculado a ningún proyecto");
		}
		return null;

	}

}
