package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatronDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nombre;
	
	private Instant fechaCreacion;
	
	private AutorDTO autor;
	
	private Set<DescripcionDTO> descripciones = new HashSet<>();
	
	private List<ProyectoDTO> proyectos = new ArrayList<>();
	
	private Set<LeccionDTO> lecciones = new HashSet<>();

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
	public Instant getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Instant fechaCreacion) {
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
	 * @return the descripciones
	 */
	public Set<DescripcionDTO> getDescripciones() {
		return descripciones;
	}

	/**
	 * @param descripciones the descripciones to set
	 */
	public void setDescripciones(Set<DescripcionDTO> descripciones) {
		this.descripciones = descripciones;
	}

	/**
	 * @return the lecciones
	 */
	public Set<LeccionDTO> getLecciones() {
		return lecciones;
	}

	/**
	 * @param lecciones the lecciones to set
	 */
	public void setLecciones(Set<LeccionDTO> lecciones) {
		this.lecciones = lecciones;
	}

	
}