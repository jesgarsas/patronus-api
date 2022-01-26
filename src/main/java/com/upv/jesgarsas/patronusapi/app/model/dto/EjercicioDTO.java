package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.upv.jesgarsas.patronusapi.app.model.entity.LocalTypes;

public class EjercicioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private PatronDTO patron;
	
	private LocalTypes locale;
	
	private String nombre;

	private Instant fechaCreacion;
	
	private String nombreAutor;
	
	private Integer idAutor;
	
	private List<PreguntaDTO> preguntas = new ArrayList<>();
	
	private Integer numPreguntas;
	
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
	public LocalTypes getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(LocalTypes locale) {
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

}
