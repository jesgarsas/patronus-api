package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagePatronDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<PatronDTO> patrones = new ArrayList<>();
	
	private Long totalElements;
	
	private Integer totalPages;
	
	public PagePatronDTO() {
		
	}

	/**
	 * @return the patrones
	 */
	public List<PatronDTO> getPatrones() {
		return patrones;
	}

	/**
	 * @param patrones the patrones to set
	 */
	public void setPatrones(List<PatronDTO> patrones) {
		this.patrones = patrones;
	}

	/**
	 * @return the totalElements
	 */
	public Long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
