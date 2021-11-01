package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.util.List;

public class UsuarioDetailsDTO extends UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String profesor;
	
	private String profesorEmail;
	
	private String grupo;
	
	private List<String> grupos;

	public UsuarioDetailsDTO() {
		super();
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

	/**
	 * @return the profesorEmail
	 */
	public String getProfesorEmail() {
		return profesorEmail;
	}

	/**
	 * @param profesorEmail the profesorEmail to set
	 */
	public void setProfesorEmail(String profesorEmail) {
		this.profesorEmail = profesorEmail;
	}

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the grupos
	 */
	public List<String> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}

}
