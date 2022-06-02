package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class LastEjercicioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Double nota;
	private Integer intento;
	private Timestamp fecha;
	private Integer ejercicioId;
	
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
	 * @return the intento
	 */
	public Integer getIntento() {
		return intento;
	}
	/**
	 * @param intento the intento to set
	 */
	public void setIntento(Integer intento) {
		this.intento = intento;
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
	 * @return the ejercicioId
	 */
	public Integer getEjercicioId() {
		return ejercicioId;
	}
	/**
	 * @param ejercicioId the ejercicioId to set
	 */
	public void setEjercicioId(Integer ejercicioId) {
		this.ejercicioId = ejercicioId;
	}
}
