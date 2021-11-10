package com.upv.jesgarsas.patronusapi.app.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Clase representadora de la tabla de la BD
 * @author theso
 *
 */
@Table(name = "Usuario")
@Entity
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "GEN_SEQ_USUARIO", allocationSize = 1, sequenceName = "SEQ_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_USUARIO")
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "rol_id")
	private Integer rolId;
	
	@Column(name = "nick", length = 100)
	private String nick;
	
	@Column(name = "password", length = 100)
	private String password;
	
	@Column(name = "last_patron")
	private Integer lastPatron;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "R_GRUPO_ALUMNO", joinColumns = {@JoinColumn(name = "id_usuario")}, inverseJoinColumns = {@JoinColumn(name = "id_grupo")})
	private Set<Grupo> grupo = new HashSet<>();;

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

	/**
	 * @return the grupo
	 */
	public Set<Grupo> getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Set<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	
}
