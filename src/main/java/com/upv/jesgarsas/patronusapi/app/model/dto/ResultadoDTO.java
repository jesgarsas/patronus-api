package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer idEjercicio;
	
	private LocalTypesDTO locale;
	
	public ResultadoDTO() {
		super();
	}

	private List<PreguntaDTO> preguntas = new ArrayList<>();

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
	 * @return the idEjercicio
	 */
	public Integer getIdEjercicio() {
		return idEjercicio;
	}

	/**
	 * @param idEjercicio the idEjercicio to set
	 */
	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	/**
	 * @return the locale
	 */
	public LocalTypesDTO getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(LocalTypesDTO locale) {
		this.locale = locale;
	}

	/**
	 * @return the preguntas
	 */
	public List<PreguntaDTO> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(List<PreguntaDTO> preguntas) {
		this.preguntas = preguntas;
	}
}
