package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_OPCION", allocationSize = 1, sequenceName = "SEQ_OPCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_OPCION")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "texto")
	private String texto;
	
	@Column(name = "opcion")
	private Integer opcion;
	
	@Column(name = "correcta")
	private Boolean correcta;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;
	
	public Opcion() {
		
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * @return the opcion
	 */
	public Integer getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(Integer opcion) {
		this.opcion = opcion;
	}

	/**
	 * @return the pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the correcta
	 */
	public Boolean getCorrecta() {
		return correcta;
	}

	/**
	 * @param correcta the correcta to set
	 */
	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}
	
}
