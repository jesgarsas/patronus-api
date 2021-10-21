package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDTO<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<E> content = new ArrayList<>();
	
	private Long totalElements;
	
	private Integer totalPages;
	
	public PageDTO() {
		
	}

	/**
	 * @return the content
	 */
	public List<E> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<E> content) {
		this.content = content;
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
