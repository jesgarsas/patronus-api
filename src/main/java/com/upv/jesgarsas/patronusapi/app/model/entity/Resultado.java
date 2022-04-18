package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RESULTADO")
public class Resultado {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_RESULTADO", allocationSize = 1, sequenceName = "SEQ_RESULTADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_RESULTADO")
	@Column(name = "id")
	private Integer id;

	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "id_ejercicio")
	private Integer idEjercicio;
	
	@Column(name = "id_pregunta")
	private Integer idPregunta;
	
	@Column(name = "id_opcion")
	private Integer idOpcion;
	
	@Column(name = "marcada")
	private Boolean marcada;
	
	@Column(name = "intento")
	private Integer intento;

	public Resultado() {
	}

	public Resultado(Integer idUsuario, Integer idEjercicio, Integer idPregunta, Integer idOpcion, Boolean marcada, Integer intento) {
		super();
		this.idUsuario = idUsuario;
		this.idEjercicio = idEjercicio;
		this.idPregunta = idPregunta;
		this.idOpcion = idOpcion;
		this.marcada = marcada == null ? false : marcada;
		this.intento = intento;
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

	/*
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

	/**
	 * @return the idEjercicio
	 */
	public Integer getIdEjercicio() {
		return idEjercicio;
	}

	/**
	 * @param idEjercicio the idEjercicio to set
	 */
	public void setIdEjercicio(Integer idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	/**
	 * @return the idPregunta
	 */
	public Integer getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the idOpcion
	 */
	public Integer getIdOpcion() {
		return idOpcion;
	}

	/**
	 * @param idOpcion the idOpcion to set
	 */
	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	/**
	 * @return the marcada
	 */
	public Boolean getMarcada() {
		return marcada;
	}

	/**
	 * @param marcada the marcada to set
	 */
	public void setMarcada(Boolean marcada) {
		this.marcada = marcada;
	}

	/**
	 * @return the intento
	 */
	public Integer getIntento() {
		return intento;
	}

	/**
	 * @param intento the intento to set
	 */
	public void setIntento(Integer intento) {
		this.intento = intento;
	}
}
