package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

public class DescripcionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String descripcion;
	
	private LocalTypesDTO locale;
	
	public DescripcionDTO() {
		
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
}
