package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "descripcion")
public class Descripcion {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "descripcion", length = 250)
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_locale")
	private LocalTypes locale;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patron")
	private Patron patron;
	
	public Descripcion() {
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
}
