package com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasEjercicioDTO implements Serializable {

	/** Serial version UID */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String nombre;
	
	private int numeroPreguntas;
	
	private List<EstadisticasGrupoDTO> grupos = new ArrayList<EstadisticasGrupoDTO>();

	public EstadisticasEjercicioDTO() {
	}

	/**
	 * @return the grupos
	 */
	public List<EstadisticasGrupoDTO> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<EstadisticasGrupoDTO> grupos) {
		this.grupos = grupos;
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
	 * @return the numeroPreguntas
	 */
	public int getNumeroPreguntas() {
		return numeroPreguntas;
	}

	/**
	 * @param numeroPreguntas the numeroPreguntas to set
	 */
	public void setNumeroPreguntas(int numeroPreguntas) {
		this.numeroPreguntas = numeroPreguntas;
	}
	
	
}
