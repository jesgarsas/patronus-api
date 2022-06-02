package com.upv.jesgarsas.patronusapi.app.repository.interfaces;

import java.sql.Timestamp;

public interface ILastEjercicio {
	public String getNombre();
	/**
	 * @return the nota
	 */
	public Double getNota();
	/**
	 * @return the intento
	 */
	public Integer getIntento();
	/**
	 * @return the fecha
	 */
	public Timestamp getFecha();
	/**
	 * @return the ejercicioId
	 */
	public Integer getEjercicioId();
}
