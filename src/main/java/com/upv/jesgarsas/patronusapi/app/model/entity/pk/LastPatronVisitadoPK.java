package com.upv.jesgarsas.patronusapi.app.model.entity.pk;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.lang.NonNull;

public class LastPatronVisitadoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NonNull
	private Integer idUsuario;
	
	@NonNull
	private Integer idPatron;

	public LastPatronVisitadoPK() {
		
	}

	public LastPatronVisitadoPK(Integer idUsuario, Integer idPatron) {
		super();
		this.idUsuario = idUsuario;
		this.idPatron = idPatron;
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

	/**
	 * @return the idPatron
	 */
	public Integer getIdPatron() {
		return idPatron;
	}

	/**
	 * @param idPatron the idPatron to set
	 */
	public void setIdPatron(Integer idPatron) {
		this.idPatron = idPatron;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPatron, idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LastPatronVisitadoPK other = (LastPatronVisitadoPK) obj;
		return Objects.equals(idPatron, other.idPatron) && Objects.equals(idUsuario, other.idUsuario);
	}
}
