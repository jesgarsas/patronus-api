package com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas;

import java.io.Serializable;

public class EstadisticasPreguntaDTO implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Boolean correcta = true;

	public EstadisticasPreguntaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadisticasPreguntaDTO(Integer id) {
		super();
		this.id = id;
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
	
	@Override
	public boolean equals(Object o) {
		return o instanceof EstadisticasPreguntaDTO && ((EstadisticasPreguntaDTO) o).getId() == this.id;
	}
}
