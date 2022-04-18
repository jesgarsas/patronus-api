package com.upv.jesgarsas.patronusapi.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upv.jesgarsas.patronusapi.app.model.dto.OpcionDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.PreguntaDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.ResultadoDTO;
import com.upv.jesgarsas.patronusapi.app.model.dto.filter.JWTAuthorizationFilter;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;
import com.upv.jesgarsas.patronusapi.app.model.entity.Opcion;
import com.upv.jesgarsas.patronusapi.app.model.entity.Pregunta;
import com.upv.jesgarsas.patronusapi.app.model.entity.Resultado;
import com.upv.jesgarsas.patronusapi.app.repository.ResultadoRepository;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository resultadoRepository;

	@Autowired
	private EjercicioService ejercicioService;

	public void save(ResultadoDTO resultado) {
		if (resultado == null || resultado.getIdEjercicio() == null) {
			return;
		}
		Integer userId = JWTAuthorizationFilter.getUserId();
		Integer nextIntento = resultadoRepository.getMaxIntento(userId, resultado.getIdEjercicio());
		nextIntento = nextIntento == null ? 0 : nextIntento;
		if (canUsuarioHacerEjercicio(resultado.getIdEjercicio())) {
			List<Resultado> resultados = new ArrayList<>();
			nextIntento++;
			for (PreguntaDTO res : resultado.getPreguntas()) {
				for (OpcionDTO resOp : res.getOpciones()) {
					resultados.add(new Resultado(userId, resultado.getIdEjercicio(), res.getId(), resOp.getId(),
							resOp.getCorrecta(), nextIntento));
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
}
