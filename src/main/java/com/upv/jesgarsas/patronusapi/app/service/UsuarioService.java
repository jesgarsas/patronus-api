package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;
import com.upv.jesgarsas.patronusapi.app.repository.UsuarioRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.UsuarioMapper;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public List<UsuarioDTO> findAllUsuarios() {
		return usuarioMapper.toListDto(usuarioRepository.findAll());
	}

	/**
	 * Comprueba que la password enviada sea la misma que la BD
	 * @param user
	 * @param password
	 * @return usuarioDTO
	 */
	public UsuarioDTO comparePassword(String nick, String password) {
		Usuario user = usuarioRepository.findByNickAndPassword(nick, password);
		if (user != null) {
			return usuarioMapper.toDto(user);
		}
		return null;
	}
}
