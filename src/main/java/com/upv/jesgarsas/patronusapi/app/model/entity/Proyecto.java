package com.upv.jesgarsas.patronusapi.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@SequenceGenerator(name = "GEN_SEQ_PROYECTO", allocationSize = 1, sequenceName = "SEQ_PROYECTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_PROYECTO")
	@Column(name = "id")
	private Integer id;
	
	@Lob
	@Column(name = "archivo")
	private byte[] archivo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "tamanyo")
	private Integer size;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patron", referencedColumnName = "id")
	private Patron patron;
	
	public Proyecto() {}

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
	 * @return the archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	
}
