package com.upv.jesgarsas.patronusapi.app.model.dto.filter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class EjercicioFilterDTO extends IFilterDTO{

	private String nombre;
	
	private String profesor;
	
	private Instant dateIni;
	
	private Instant dateFin;
	
	private String patron;
	
	public EjercicioFilterDTO() {
		
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
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

	/**
	 * @return the patron
	 */
	public String getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(String patron) {
		this.patron = patron;
	}
	
}
