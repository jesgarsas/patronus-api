package com.upv.jesgarsas.patronusapi.app.repository.interfaces;

import java.time.Instant;

public interface IEjercicioTable {
	/**
	 * @return the id
	 */
	public Integer getId();

	/**
	 * @return the nombre
	 */
	public String getNombre();

	/**
	 * @return the fechaCreacion
	 */
	public Instant getFechaCreacion();

	/**
	 * @return the nombreAutor
	 */
	public String getNombreAutor();

	/**
	 * @return the numPreguntas
	 */
	public Integer getNumPreguntas();
	/**
	 * @return the intentos
	 */
	public Integer getIntentos();

	/**
	 * @return the nota
	 */
	public Double getNota();

	/**
	 * @return the realizados
	 */
	public Integer getRealizados();
}
