package com.upv.jesgarsas.patronusapi.app.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.OpcionDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PreguntaDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.ResultadoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas.EstadisticasAlumnoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas.EstadisticasEjercicioDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas.EstadisticasGrupoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas.EstadisticasPreguntaDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.JWTAuthorizationFilter;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.model.entity.Opcion;
import com.upv.jesgarsas.patronusapi.app.model.entity.Pregunta;
import com.upv.jesgarsas.patronusapi.app.model.entity.Resultado;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;
import com.upv.jesgarsas.patronusapi.app.repository.ResultadoRepository;
import com.upv.jesgarsas.patronusapi.app.repository.interfaces.IEstadisticaPregunta;
import com.upv.jesgarsas.patronusapi.app.service.mapper.EstadisticasEjercicioMapper;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository resultadoRepository;

	@Autowired
	private EjercicioService ejercicioService;
	
	@Autowired
	private EstadisticasEjercicioMapper estadisticasEjerMapper;
	
	@Autowired GrupoService grupoService;

	public void save(ResultadoDTO resultado) {
		if (resultado == null || resultado.getIdEjercicio() == null) {
			return;
		}
		Integer userId = JWTAuthorizationFilter.getUserId();
		Integer nextIntento = resultadoRepository.getMaxIntento(userId, resultado.getIdEjercicio());
		nextIntento = nextIntento == null ? 0 : nextIntento;
		if (canUsuarioHacerEjercicio(resultado.getIdEjercicio())) {
			List<Resultado> resultados = new ArrayList<>();
			Timestamp fecha = new Timestamp((new Date()).getTime());
			nextIntento++;
			for (PreguntaDTO res : resultado.getPreguntas()) {
				for (OpcionDTO resOp : res.getOpciones()) {
					resultados.add(new Resultado(userId, resultado.getIdEjercicio(), res.getId(), resOp.getId(),
							resOp.getCorrecta(), nextIntento, fecha));
				}
			}
			resultadoRepository.saveAll(resultados);
		}

	}

	public boolean canUsuarioHacerEjercicio(Integer idEjercicio) {
		if (idEjercicio == null) {
			return false;
		}
		Ejercicio ejercicio = ejercicioService.findEntityById(idEjercicio);
		if (ejercicio != null) {
			Integer userId = JWTAuthorizationFilter.getUserId();
			Integer nextIntento = resultadoRepository.getMaxIntento(userId, idEjercicio);
			return nextIntento == null || ejercicio.getIntentos() == null || nextIntento + 1 <= ejercicio.getIntentos();
		}
		return false;
	}
	
	public Double getNotaUsuario(Integer idUsuario, Integer idEjercicio) {
		Ejercicio ejercicio = ejercicioService.findEntityById(idEjercicio);
		Integer maxIntento = resultadoRepository.getMaxIntento(idUsuario, idEjercicio);
		List<Resultado> resultados = resultadoRepository.findByIdUsuarioAndIdEjercicioAndIntento(idUsuario, idEjercicio, maxIntento);
		if (ejercicio != null && resultados != null && !resultados.isEmpty()) {
			double incorrectas = checkPreguntaIncorrecta(ejercicio, resultados);
			try {
				return 10.00 - 10.0 * (incorrectas / ejercicio.getPreguntas().size());
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	private double checkPreguntaIncorrecta(Ejercicio ejercicio, List<Resultado> resultados) {
		double incorrectas = 0;
		for (Pregunta pregunta : ejercicio.getPreguntas()) {
			boolean correcta = true;
			boolean haContestado = false;
			for (Opcion opcion : pregunta.getOpciones()) {
				for (Resultado resultado : resultados) {
					if (pregunta.getId().equals(resultado.getIdPregunta()) && opcion.getId().equals(resultado.getIdOpcion())) {
						haContestado = true;
						correcta = correcta && resultado.getMarcada() == opcion.getCorrecta();
					}
				}
			}
			if (!correcta || !haContestado) {
				incorrectas++;
			}
		}
		return incorrectas;
	}

	public Object getEstadisticas(Integer idEjercicio, Integer[] idGrupos) {
		Ejercicio ejercicio = ejercicioService.findEntityById(idEjercicio);
		if (ejercicio != null) {
			EstadisticasEjercicioDTO estadisticas = estadisticasEjerMapper.toDto(ejercicio);
			estadisticas.setNumeroPreguntas(ejercicio.getPreguntas().size());
			estadisticas.setPreguntas(ejercicio.getPreguntas().stream().map(ejer -> ejer.getPregunta()).collect(Collectors.toList()));
			getEstadisticasGrupo(idEjercicio, idGrupos, estadisticas);
			return estadisticas;
		}
		return null;
	}

	private void getEstadisticasGrupo(Integer idEjercicio, Integer[] idGrupos, EstadisticasEjercicioDTO estadisticas) {
		for (Integer idGrupo : idGrupos) {
			Grupo grupo = grupoService.findById(idGrupo);
			EstadisticasGrupoDTO estGrupo = new EstadisticasGrupoDTO(grupo.getNombre(), grupo.getAlumnos().size());
			estGrupo.setId(grupo.getId());
			estadisticas.getGrupos().add(estGrupo);
			getEstadisticasAlumno(idEjercicio, grupo, estGrupo);
		}
	}

	private void getEstadisticasAlumno(Integer idEjercicio, Grupo grupo, EstadisticasGrupoDTO estGrupo) {
		for (Usuario alumno : grupo.getAlumnos()) {
			EstadisticasAlumnoDTO estAlumno = new EstadisticasAlumnoDTO(alumno.getNick(), alumno.getEmail());
			estAlumno.setNota(getNotaUsuario(alumno.getId(), idEjercicio));
			estGrupo.addAlumno(estAlumno);
			if (estAlumno.getNota() != null) {
				getEstadisticasAlumnoPregunta(idEjercicio, grupo, alumno, estAlumno);
			}
		}
	}

	private void getEstadisticasAlumnoPregunta(Integer idEjercicio, Grupo grupo, Usuario alumno, EstadisticasAlumnoDTO estAlumno) {
		List<IEstadisticaPregunta> resultados = resultadoRepository.findByIdUsuarioAndIdEjercicioAndIntentoAndLast(alumno.getId(), idEjercicio, grupo.getId());
		if (resultados != null) {
			for (IEstadisticaPregunta resultado : resultados) {
				EstadisticasPreguntaDTO estPregunta = new EstadisticasPreguntaDTO(resultado.getId());
				estAlumno.setFecha(resultado.getFecha());
				int index = estAlumno.getEjercicios().indexOf(estPregunta);
				if (index != -1) {
					estPregunta = estAlumno.getEjercicios().get(index);
				} else {
					estAlumno.getEjercicios().add(estPregunta);
				}
				if (resultado.getCorrecta() != null) {
					estPregunta.setCorrecta(estPregunta.getCorrecta() && resultado.getCorrecta() == 1);
				}	
			}
		}
	}
}
