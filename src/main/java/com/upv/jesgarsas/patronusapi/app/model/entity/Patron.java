package com.upv.jesgarsas.patronusapi.app.model.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patron")
public class Patron {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_PATRON", allocationSize = 1, sequenceName = "SEQ_PATRON")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_PATRON")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "fecha_creacion")
	private Instant fechaCreacion;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "autor", referencedColumnName = "id")
	private Usuario autor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patron", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Set<Leccion> lecciones = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patron", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Set<Descripcion> descripciones = new HashSet<>();

	public Patron() {
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
	public Usuario getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	/**
	 * @return the lecciones
	 */
	public Set<Leccion> getLecciones() {
		return lecciones;
	}

	/**
	 * @param lecciones the lecciones to set
	 */
	public void setLecciones(Set<Leccion> lecciones) {
		this.lecciones = lecciones;
	}

	/**
	 * @return the descripciones
	 */
	public Set<Descripcion> getDescripciones() {
		return descripciones;
	}

	/**
	 * @param descripciones the descripciones to set
	 */
	public void setDescripciones(Set<Descripcion> descripciones) {
		this.descripciones = descripciones;
	}

}
