package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios() {
		return ResponseEntity.ok(usuarioService.findAllUsuarios());
	}
}
