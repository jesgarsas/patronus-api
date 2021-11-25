package com.upv.jesgarsas.patronusapi.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDetailsDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.UsuarioFilterDTO;
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
	public ResponseEntity<UsuarioDTO> login(@RequestParam(name = "nick") String nick,
			@RequestParam("password") String password) {
		UsuarioDTO user = usuarioService.comparePassword(nick, password);
		if (user != null) {
			String token = JwtService.getJWTToken(user.getNick(), user.getRolId(), user.getId());
			user.setNick(nick);
			user.setToken(token);
			return ResponseEntity.ok(user);

		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/profesor/all")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios() {
		return ResponseEntity.ok(usuarioService.findAllUsuarios());
	}

	@GetMapping("/profesor/type/{types}")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuariosByType(@PathVariable(name = "types") String types) {
		return ResponseEntity.ok(usuarioService.findAllUsuariosByTypes(types));
	}

	@GetMapping("/alumno/{id}")
	public ResponseEntity<UsuarioDetailsDTO> findAllUsuarios(@PathVariable(name = "id") Integer id,
			@PathParam("token") String token) {
		if (this.JwtService.isSameIdUser(token, id)) {
			return ResponseEntity.ok(usuarioService.findUsuarioDetalles(id));
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Denied");
		}
	}

	@PostMapping("/alumno/changePassword")
	public ResponseEntity<Boolean> changePassword(@RequestPart(name = "newPassword") String newPassword,
			@RequestPart(name = "password") String password, @RequestPart(name = "nick") String nick) {
		if (usuarioService.comparePassword(nick, password) != null) {
			return ResponseEntity.ok(usuarioService.changePassword(newPassword, nick, password));
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access Denied");
		}
	}
	
	@PostMapping("/profesor/resetPassword/{id}")
	public ResponseEntity<Boolean> resetPassword(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(usuarioService.resetPassword(id));
	}

	@PostMapping("/profesor/grupo")
	public ResponseEntity<PageDTO<UsuarioDTO>> findByGrupo(@RequestBody(required = true) UsuarioFilterDTO filter) {
		return ResponseEntity.ok(this.usuarioService.findAllUsuariosByGrupo(filter));
	}

	@PostMapping("/profesor/create")
	public ResponseEntity<UsuarioDTO> create(@RequestBody(required = true) UsuarioDTO usuario) {
		try {
			return ResponseEntity.ok(this.usuarioService.create(usuario));
		} catch (Exception e) {
			return ResponseEntity.ok(null);
		}
	}

	@PostMapping("/profesor/create-from-file/{id}")
	public ResponseEntity<List<String>> createFromFile(@RequestBody(required = true) MultipartFile file,
			@PathVariable(name = "id", required = true) Integer grupoId) {
		return ResponseEntity.ok(this.usuarioService.createFromFile(file, grupoId));
	}

	@GetMapping("/plantilla")
	public ResponseEntity<InputStreamResource> getPlantilla() {
		File file = usuarioService.getPlantilla();
		if (file != null) {
			InputStreamResource in;
			try {
				in = new InputStreamResource(new FileInputStream(file));
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "Plantilla importación alumnos.xlsx")
						.contentLength(file.length()) //
						.body(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/profesor/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Integer id) {
		return ResponseEntity.ok(this.usuarioService.delete(id));
	}
	
	@PostMapping("/profesor/all/filtered")
	public ResponseEntity<PageDTO<UsuarioDTO>> findAllGruposFiltered(@RequestBody(required = true) UsuarioFilterDTO filter) {
		return ResponseEntity.ok(usuarioService.findAllUsuariosByGrupo(filter));
	}
	
	@PostMapping("/administrador/edit")
	public ResponseEntity<Boolean> editUser(@RequestBody(required = true) UsuarioDTO usuario) {
		return ResponseEntity.ok(usuarioService.edit(usuario));
	}
}
