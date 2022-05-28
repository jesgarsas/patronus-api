package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

public class GrupoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nombre;
	
	private String label;
	
	private UsuarioDTO profesor;
	
	private Integer alumnosCount;
	
	public GrupoDTO() {}

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
	public UsuarioDTO getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(UsuarioDTO profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the alumnosCount
	 */
	public Integer getAlumnosCount() {
		return alumnosCount;
	}

	/**
	 * @param alumnosCount the alumnosCount to set
	 */
	public void setAlumnosCount(Integer alumnosCount) {
		this.alumnosCount = alumnosCount;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
