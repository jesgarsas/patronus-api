package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private PatronDTO patron;
	
	private LocalTypesDTO locale;
	
	private String nombre;

	private Instant fechaCreacion;
	
	private String nombreAutor;
	
	private Integer idAutor;
	
	private List<PreguntaDTO> preguntas = new ArrayList<>();
	
	private Integer numPreguntas;
	
	private Integer intentos;
	
	private Double nota;
	
	private Integer realizados;
	
	public EjercicioDTO() {
		
	}

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
	 * @return the patron
	 */
	public PatronDTO getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(PatronDTO patron) {
		this.patron = patron;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Instant getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Instant fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the numPreguntas
	 */
	public Integer getNumPreguntas() {
		return numPreguntas;
	}

	/**
	 * @param numPreguntas the numPreguntas to set
	 */
	public void setNumPreguntas(Integer numPreguntas) {
		this.numPreguntas = numPreguntas;
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

	/**
	 * @return the nombreAutorString
	 */
	public String getNombreAutor() {
		return nombreAutor;
	}

	/**
	 * @param nombreAutorString the nombreAutorString to set
	 */
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	/**
	 * @return the idAutor
	 */
	public Integer getIdAutor() {
		return idAutor;
	}

	/**
	 * @param idAutor the idAutor to set
	 */
	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	/**
	 * @return the intentos
	 */
	public Integer getIntentos() {
		return intentos;
	}

	/**
	 * @param intentos the intentos to set
	 */
	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	/**
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
	}

	/**
	 * @return the realizados
	 */
	public Integer getRealizados() {
		return realizados;
	}

	/**
	 * @param realizados the realizados to set
	 */
	public void setRealizados(Integer realizados) {
		this.realizados = realizados;
	}

}
