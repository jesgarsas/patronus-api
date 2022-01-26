package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreguntaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String pregunta;

	private Integer respuesta;

	private List<OpcionDTO> opciones = new ArrayList<>();
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuesta
	 */
	public Integer getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Integer respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the opciones
	 */
	public List<OpcionDTO> getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones the opciones to set
	 */
	public void setOpciones(List<OpcionDTO> opciones) {
		this.opciones = opciones;
	}
}
