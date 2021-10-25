package com.upv.jesgarsas.patronusapi.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.service.JWTService;
import com.upv.jesgarsas.patronusapi.app.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JWTService JwtService;

	@PostMapping("/login")
	public ResponseEntity<UsuarioDTO> login(@RequestParam(name = "nick") String nick, @RequestParam("password") String password) {
		UsuarioDTO user = usuarioService.comparePassword(nick, password);
		if (user != null) {
			String token = JwtService.getJWTToken(user.getNick(), user.getRolId());
			user.setNick(nick);
			user.setToken(token);
			return ResponseEntity.ok(user);
			
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios() {
		return ResponseEntity.ok(usuarioService.findAllUsuarios());
	}
}
