package com.upv.jesgarsas.patronusapi.app.model.dto.filter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PatronFilterDTO extends IFilterDTO  {
	
	private String name;
	
	private String autor;
	
	private Instant dateIni;
	
	private Instant dateFin;
	
	public PatronFilterDTO() {}

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
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the dateIni
	 */
	public Instant getDateIni() {
		return dateIni;
	}

	/**
	 * @param dateIni the dateIni to set
	 */
	public void setDateIni(Instant dateIni) {
		this.dateIni = dateIni;
	}

	/**
	 * @return the dateFin
	 */
	public Instant getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Instant dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * Añade el tiempo para el ultimo instante del dia
	 */
	public void addTimeToDateFin() {
		if (dateFin != null) {
		this.dateFin = this.dateFin.plus(23, ChronoUnit.HOURS).plus(59, ChronoUnit.MINUTES).plus(59, ChronoUnit.SECONDS);
		}
	}
	
}
