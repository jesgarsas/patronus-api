package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

public class LocalTypesDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String code;
	
	public LocalTypesDTO() {
		
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
}
