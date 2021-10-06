package com.upv.jesgarsas.patronusapi.app.model.dto;

public class LeccionDTO {

	private Integer id;
	
	private String contenido;
	
	private LocalTypesDTO locale;
	
	public LeccionDTO() {}

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
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
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
