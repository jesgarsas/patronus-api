package com.upv.jesgarsas.patronusapi.app.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.upv.jesgarsas.patronusapi.app.model.entity.pk.LastPatronVisitadoPK;

@Entity
@Table(name = "LAST_PATRON_VISITADO")
public class LastPatronVisitado {
	
	public static String FECHA = "fecha";
	
	@EmbeddedId
	private LastPatronVisitadoPK id;
	
	@Column(name = "FECHA")
	private Timestamp fecha;
	
	public LastPatronVisitado() {
		
	}

	public LastPatronVisitado(LastPatronVisitadoPK id, Timestamp fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}

	/**
	 * @return the id
	 */
	public LastPatronVisitadoPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(LastPatronVisitadoPK id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LastPatronVisitado other = (LastPatronVisitado) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
