package com.upv.jesgarsas.patronusapi.app.model.dto.filter;

public class UsuarioFilterDTO extends IFilterDTO {
	
	private Integer idGrupo;
	
	public UsuarioFilterDTO() {
		
	}

	/**
	 * @return the id
	 */
	public Integer getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdGrupo(Integer id) {
		this.idGrupo = id;
	}
	
}
