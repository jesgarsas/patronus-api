package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Leccion")
public class Leccion {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_LECCION", allocationSize = 1, sequenceName = "SEQ_LECCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_LECCION")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "contenido")
	private String contenido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patron")
	private Patron patron;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local")
	private LocalTypes locale;
	
	public Leccion() {}

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
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	/**
	 * @return the locale
	 */
	public LocalTypes getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(LocalTypes locale) {
		this.locale = locale;
	}
	
}
