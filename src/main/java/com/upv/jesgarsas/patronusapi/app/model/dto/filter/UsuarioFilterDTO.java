package com.upv.jesgarsas.patronusapi.app.model.dto.filter;

public class UsuarioFilterDTO extends IFilterDTO {
	
	private Integer idGrupo;
	
	private String name;
	
	private String email;
	
	private Integer type;
	
	public UsuarioFilterDTO() {
		
	}

	/**
	 * @return the id
	 */
	public Integer getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdGrupo(Integer id) {
		this.idGrupo = id;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
}
