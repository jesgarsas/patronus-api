package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESULTADO")
public class Resultado {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "correctas")
	private Integer correctas;
	
	@Column(name = "fallos")
	private Integer fallos;
	
	@Column(name = "id_usuario")
	private Integer idUsuario;

	public Resultado() {}	

	public Resultado(Integer correctas, Integer fallos, Integer idUsuario) {
		this.correctas = correctas;
		this.fallos = fallos;
		this.idUsuario = idUsuario;
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
	 * @return the correctas
	 */
	public Integer getCorrectas() {
		return correctas;
	}

	/**
	 * @param correctas the correctas to set
	 */
	public void setCorrectas(Integer correctas) {
		this.correctas = correctas;
	}

	/**
	 * @return the fallos
	 */
	public Integer getFallos() {
		return fallos;
	}

	/**
	 * @param fallos the fallos to set
	 */
	public void setFallos(Integer fallos) {
		this.fallos = fallos;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
