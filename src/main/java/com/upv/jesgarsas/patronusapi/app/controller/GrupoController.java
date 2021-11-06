package com.upv.jesgarsas.patronusapi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
	public ResponseEntity<PageDTO<GrupoDTO>> findAllPatronesFiltered(@RequestBody(required = true) GrupoFilterDTO filter) {
		return ResponseEntity.ok(grupoService.findAllGruposPageable(filter));
	}
}
