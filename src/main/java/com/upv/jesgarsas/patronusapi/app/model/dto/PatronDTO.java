package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PatronDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nombre;
	
	private Date fechaCreacion;
	
	private AutorDTO autor;
	
	private DescripcionDTO descripcion;
	
	private List<ProyectoDTO> proyectos;
	
	private LeccionDTO leccion;

	public PatronDTO() {
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
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the autor
	 */
	public AutorDTO getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	/**
	 * @return the descripcion
	 */
	public DescripcionDTO getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(DescripcionDTO descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the proyectos
	 */
	public List<ProyectoDTO> getProyectos() {
		return proyectos;
	}

	/**
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<ProyectoDTO> proyectos) {
		this.proyectos = proyectos;
	}

	/**
	 * @return the leccion
	 */
	public LeccionDTO getLeccion() {
		return leccion;
	}

	/**
	 * @param leccion the leccion to set
	 */
	public void setLeccion(LeccionDTO leccion) {
		this.leccion = leccion;
	}
	
}