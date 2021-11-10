package com.upv.jesgarsas.patronusapi.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upv.jesgarsas.patronusapi.app.model.dto.PageDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.UsuarioDetailsDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.UsuarioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;
import com.upv.jesgarsas.patronusapi.app.repository.UsuarioRepository;
import com.upv.jesgarsas.patronusapi.app.repository.specification.UsuarioSpecification;
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

	public List<UsuarioDTO> findAllUsuariosByTypes(String types) {
		try {
			String[] typesSplit = types.split(",");
			List<Integer> role = new ArrayList<>();
			for (int j = 0; j < typesSplit.length; j++) {
				try {
					role.add(Integer.valueOf(typesSplit[j]));
				} catch (Exception e) {
				}
			}
			return this.usuarioMapper.toListDto(this.usuarioRepository.findByRolIdIn(role));
		} catch (Exception e) {
			return null;
		}
	}

	public PageDTO<UsuarioDTO> findAllUsuariosByGrupo(UsuarioFilterDTO filter) {
		try {
			Pageable params = PageRequest.of(filter.getPageNumber(), filter.getSize());

			Page<Usuario> page = usuarioRepository.findAll(new UsuarioSpecification(filter), params);
			PageDTO<UsuarioDTO> result = new PageDTO<>();
			page.getContent().forEach(user -> {
				UsuarioDTO dto = usuarioMapper.toDto(user);
				result.getContent().add(dto);
			});
			result.setTotalElements(page.getTotalElements());
			result.setTotalPages(page.getTotalPages());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Transactional
	public UsuarioDTO create(UsuarioDTO usuario) {
		try {
			Usuario newUsuario = usuarioMapper.toEntity(usuario);
			newUsuario.setPassword("d895d4285187ba910f4a2e78ee8b7542");
			newUsuario = usuarioRepository.save(newUsuario);
			Grupo grupo = grupoService.findById(usuario.getGrupoId());
			grupo.getAlumnos().add(newUsuario);
			grupoService.save(grupo);
			return usuarioMapper.toDto(newUsuario);
		} catch (Exception e) {
			return null;
		} 
	}

	@Transactional
	public Boolean delete(Integer id) {
		try {
			this.usuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<String> createFromFile(MultipartFile file) {
		List<String> nicksAlreadyInUse = new ArrayList<>();
		// Comprobar si es un excel
		if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			throw new RuntimeException("Only excel format");
		}
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
			
			for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
			    XSSFRow row = worksheet.getRow(i);
			    Usuario usuario = new Usuario();   
			}
		} catch (IOException e) {
			throw new RuntimeException("Bad file format");
		}
		
		return nicksAlreadyInUse;
	}
}
