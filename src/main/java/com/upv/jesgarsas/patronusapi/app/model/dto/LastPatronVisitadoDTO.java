package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class LastPatronVisitadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idUsuario;
	private Integer idPatron;
	private Timestamp fecha;
	private String name;

	public LastPatronVisitadoDTO(Integer idUsuario, Integer idPatron, Timestamp fecha) {
		super();
		this.idUsuario = idUsuario;
		this.idPatron = idPatron;
		this.fecha = fecha;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idPatron
	 */
	public Integer getIdPatron() {
		return idPatron;
	}

	/**
	 * @param idPatron the idPatron to set
	 */
	public void setIdPatron(Integer idPatron) {
		this.idPatron = idPatron;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
