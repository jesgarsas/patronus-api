package com.upv.jesgarsas.patronusapi.app.model.dto.filter;

public class GrupoFilterDTO extends IFilterDTO {
	
	private String nombre;
	
	private String profesor;
	
	public GrupoFilterDTO() {
		super();
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
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
}
