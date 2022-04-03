package com.upv.jesgarsas.patronusapi.app.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pregunta")
public class Pregunta {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_PREGUNTA", allocationSize = 1, sequenceName = "SEQ_PREGUNTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_PREGUNTA")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "pregunta")
	private String pregunta;

	@Column(name = "respuesta")
	private Integer respuesta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ejercicio", referencedColumnName = "id")
	private Ejercicio ejercicio;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "pregunta")
	private Set<Opcion> opciones = new HashSet<>();
	
	/**
	 * @return the opciones
	 */
	public Set<Opcion> getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones the opciones to set
	 */
	public void setOpciones(Set<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Pregunta() {
		
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
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuesta
	 */
	public Integer getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Integer respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the ejercicio
	 */
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	/**
	 * @param ejercicio the ejercicio to set
	 */
	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}
	
}
