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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EJERCICIO")
public class Ejercicio {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_EJERCICIO", allocationSize = 1, sequenceName = "SEQ_EJERCICIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_EJERCICIO")
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patron")
	private Patron patron;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_local")
	private LocalTypes locale;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autor")
	private Usuario autor;

	@Column(name = "fecha_creacion")
	private Instant fechaCreacion;
	
	@Column(name = "intentos")
	private Integer intentos;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "ejercicio")
	private Set<Pregunta> preguntas = new HashSet<>();
	
	public Ejercicio() {
		
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
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}

	/**
	 * @param patron the patron to set
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	/**
	 * @return the locale
	 */
	public LocalTypes getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(LocalTypes locale) {
		this.locale = locale;
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
	 * @return the preguntas
	 */
	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	/**
	 * @param preguntas the preguntas to set
	 */
	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
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
	 * @return the intentos
	 */
	public Integer getIntentos() {
		return intentos;
	}

	/**
	 * @param intentos the intentos to set
	 */
	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}
	
}
