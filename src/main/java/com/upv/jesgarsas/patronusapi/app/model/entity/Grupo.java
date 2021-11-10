package com.upv.jesgarsas.patronusapi.app.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_GRUPO", allocationSize = 1, sequenceName = "SEQ_GRUPO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_GRUPO")
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profesor", referencedColumnName = "id")
	private Usuario profesor;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "R_grupo_alumno", joinColumns = {@JoinColumn(name="id_grupo")}, inverseJoinColumns = {@JoinColumn(name = "id_usuario")})
	private Set<Usuario> alumnos = new HashSet<>();
	
	public Grupo() { }

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
	 * @return the profesor
	 */
	public Usuario getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the alumnos
	 */
	public Set<Usuario> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(Set<Usuario> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
