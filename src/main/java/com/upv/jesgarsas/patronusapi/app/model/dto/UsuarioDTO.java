package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

/**
 * Clase que representa el DTO de un usuario
 */
public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String email;
	
	private Integer rolId;
	
	private String nick;
	
	private String password;
	
	private Integer lastPatron;
	
	private String token;
	
	private Integer grupoId;

	/**
	 * 
	 * @param id
	 * @param email
	 * @param rolId
	 * @param nick
	 * @param password
	 * @param lastPatron
	 */
	public UsuarioDTO(Integer id, String email, Integer rolId, String nick, String password, Integer lastPatron) {
		this.id = id;
		this.email = email;
		this.rolId = rolId;
		this.nick = nick;
		this.password = password;
		this.lastPatron = lastPatron;
	}
	
	/**
	 * 
	 */
	public UsuarioDTO() {}

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
	 * @return the rolId
	 */
	public Integer getRolId() {
		return rolId;
	}

	/**
	 * @param rolId the rolId to set
	 */
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastPatron
	 */
	public Integer getLastPatron() {
		return lastPatron;
	}

	/**
	 * @param lastPatron the lastPatron to set
	 */
	public void setLastPatron(Integer lastPatron) {
		this.lastPatron = lastPatron;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the grupoId
	 */
	public Integer getGrupoId() {
		return grupoId;
	}

	/**
	 * @param grupoId the grupoId to set
	 */
	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
	
	

}
