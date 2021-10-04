package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase representadora de la tabla de la BD
 * @author theso
 *
 */
@Table(name = "Usuario")
@Entity
public class Usuario {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "email", length = 100)
	private String email;
	
	@Transient
	private Integer rolId;
	
	@Column(name = "nick", length = 100)
	private String nick;
	
	@Column(name = "password", length = 100)
	private String password;
	
	@Transient
	private Integer lastPatron;

	/**
	 * 
	 * @param id
	 * @param email
	 * @param rolId
	 * @param nick
	 * @param password
	 * @param lastPatron
	 */
	public Usuario(Integer id, String email, Integer rolId, String nick, String password, Integer lastPatron) {
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
	public Usuario() {}

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
	
	
}
