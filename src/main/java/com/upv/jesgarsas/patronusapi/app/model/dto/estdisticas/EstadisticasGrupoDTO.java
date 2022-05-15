package com.upv.jesgarsas.patronusapi.app.model.dto.estdisticas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasGrupoDTO implements Serializable { 
	
	/** */
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private Integer total;
	
	private Integer aprobados = 0;
	
	private Integer suspendidos = 0;
	
	private Integer noResueltos = 0;
	
	private List<EstadisticasAlumnoDTO> alumnos = new ArrayList<EstadisticasAlumnoDTO>();

	public EstadisticasGrupoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadisticasGrupoDTO(String nombre, Integer total) {
		super();
		this.nombre = nombre;
		this.total = total;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the aprobados
	 */
	public Integer getAprobados() {
		return aprobados;
	}

	/**
	 * @param aprobados the aprobados to set
	 */
	public void setAprobados(Integer aprobados) {
		this.aprobados = aprobados;
	}

	/**
	 * @return the suspendidos
	 */
	public Integer getSuspendidos() {
		return suspendidos;
	}

	/**
	 * @param suspendidos the suspendidos to set
	 */
	public void setSuspendidos(Integer suspendidos) {
		this.suspendidos = suspendidos;
	}

	/**
	 * @return the noResueltos
	 */
	public Integer getNoResueltos() {
		return noResueltos;
	}

	/**
	 * @param noResueltos the noResueltos to set
	 */
	public void setNoResueltos(Integer noResueltos) {
		this.noResueltos = noResueltos;
	}

	/**
	 * @return the alumnos
	 */
	public List<EstadisticasAlumnoDTO> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(List<EstadisticasAlumnoDTO> alumnos) {
		this.alumnos = alumnos;
	}
	
	/**
	 * Añade el alumno a la lista de alumnos y suma al contador según su nota
	 * @param alumno
	 */
	public void addAlumno(EstadisticasAlumnoDTO alumno) {
		if (alumno != null) {
			this.alumnos.add(alumno);
			if (alumno.getNota() != null) {
				if (alumno.getNota() >= 5) {
					this.setAprobados(this.getAprobados() + 1);
				} else if (alumno.getNota() < 5) {
					this.setSuspendidos(this.getSuspendidos() + 1);
				}
			} else {
				this.setNoResueltos(this.getNoResueltos() + 1);
			}
		}
	}
	
}
