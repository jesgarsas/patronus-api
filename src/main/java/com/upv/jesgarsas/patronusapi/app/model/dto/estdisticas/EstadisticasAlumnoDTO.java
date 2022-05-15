package com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasAlumnoDTO implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String email;
	
	private Double nota;
	
	private Timestamp fecha;
	
	private List<EstadisticasPreguntaDTO> ejercicios = new ArrayList<EstadisticasPreguntaDTO>();

	public EstadisticasAlumnoDTO() {
		super();
	}

	public EstadisticasAlumnoDTO(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the ejercicios
	 */
	public List<EstadisticasPreguntaDTO> getEjercicios() {
		return ejercicios;
	}

	/**
	 * @param ejercicios the ejercicios to set
	 */
	public void setEjercicios(List<EstadisticasPreguntaDTO> ejercicios) {
		this.ejercicios = ejercicios;
	}
	
	
}
