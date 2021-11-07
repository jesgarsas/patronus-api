package com.upv.jesgarsas.patronusapi.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDetailsDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;
import com.upv.jesgarsas.patronusapi.app.repository.UsuarioRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.UsuarioMapper;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	@Autowired
	private GrupoService grupoService;

	public List<UsuarioDTO> findAllUsuarios() {
		return usuarioMapper.toListDto(usuarioRepository.findAll());
	}

	public UsuarioDetailsDTO findUsuarioDetalles(Integer id) {
		UsuarioDetailsDTO dto = new UsuarioDetailsDTO();
		Usuario usuario = usuarioRepository.findByIdWithoutPassword(id);
		if (usuario != null) {
			dto = usuarioMapper.toDtoDetails(usuario);
			if (usuario.getRolId() == 1) {
				Grupo grupo = grupoService.findByAlumnosId(id);
				if (grupo != null) {
					dto.setGrupo(grupo.getNombre());
					dto.setProfesor(grupo.getProfesor().getNick());
					dto.setProfesorEmail(grupo.getProfesor().getEmail());
				}
			} else {
				dto.setGrupos(
						grupoService.findByProfesorId(id).stream().map(Grupo::getNombre).collect(Collectors.toList()));
			}
		}
		return dto;
	}

	/**
	 * Comprueba que la password enviada sea la misma que la BD
	 * 
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

	public Boolean changePassword(String newPassword, String nick, String password) {
		Usuario user = usuarioRepository.findByNickAndPassword(nick, password);
		if (user != null) {
			user.setPassword(newPassword);
			usuarioRepository.save(user);
			return true;
		}
		return false;
	}

	public List<UsuarioDTO> findAllUsuariosByType(Integer type) {
		try {
			return this.usuarioMapper.toListDto(this.usuarioRepository.findByRolId(type));
		} catch (Exception e) {
			return null;
		}
	}
}
