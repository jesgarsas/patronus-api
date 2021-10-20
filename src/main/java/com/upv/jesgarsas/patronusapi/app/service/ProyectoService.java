package com.upv.jesgarsas.patronusapi.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.upv.jesgarsas.patronusapi.app.model.dto.ProyectoDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;
import com.upv.jesgarsas.patronusapi.app.model.entity.Proyecto;
import com.upv.jesgarsas.patronusapi.app.repository.ProyectoRepository;
import com.upv.jesgarsas.patronusapi.app.service.mapper.ProyectoMapper;

@Service
public class ProyectoService {

	@Autowired
	private ProyectoMapper proyectoMapper;

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Value("${app.patronus.download.projects}")
	private String urlDownloadProyecto;

	public List<ProyectoDTO> findByPatron(Integer idPatron) {
		List<ProyectoDTO> proyectos = proyectoMapper.toListDto(proyectoRepository.findAllByPatronId(idPatron));
		if (proyectos != null) {
			proyectos.forEach(proyecto -> {
				proyecto.setLink(getUrlProyecto(proyecto));
			});
			return proyectos;
		}
		
		return new ArrayList<ProyectoDTO>();
	}

	public List<Proyecto> findByPatron(Patron patron) {
		return proyectoRepository.findAllByPatronId(patron.getId());
	}

	public ProyectoDTO findById(Integer id) {
		Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
		if (proyecto != null) {
			return proyectoMapper.toDto(proyecto);
		}
		return null;
	}

	public Proyecto findByIdEntity(Integer id) {
		return proyectoRepository.findById(id).orElse(null);
	}

	public void save(Proyecto proyecto, Patron patron) {
		proyecto.setPatron(patron);
		proyectoRepository.save(proyecto);
	}

	public void delete(Proyecto proyecto) {
		proyectoRepository.delete(proyecto);
	}

	public File getFileById(Proyecto proyecto) {
		if (proyecto != null) {
			Path path;
			try {
				path = Files.createTempFile("project", null);
				Files.write(path, proyecto.getArchivo());
				File file = new File(path.toUri());
				return file;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// tiene que tener una id, devuelve "" si no
	private String getUrlProyecto(ProyectoDTO proyecto) {
		if (proyecto.getId() != null) {
			return urlDownloadProyecto.replace("{id}", String.valueOf(proyecto.getId()));
		}
		return "";
	}
}
