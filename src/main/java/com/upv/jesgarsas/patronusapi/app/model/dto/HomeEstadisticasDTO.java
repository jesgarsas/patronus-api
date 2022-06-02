package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

public class HomeEstadisticasDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	public Integer realizados;
	public Integer noRealizados;
	public Integer total;
	/**
	 * @return the realizados
	 */
	public Integer getRealizados() {
		return realizados;
	}
	/**
	 * @param realizados the realizados to set
	 */
	public void setRealizados(Integer realizados) {
		this.realizados = realizados;
	}
	/**
	 * @return the noRealizados
	 */
	public Integer getNoRealizados() {
		return noRealizados;
	}
	/**
	 * @param noRealizados the noRealizados to set
	 */
	public void setNoRealizados(Integer noRealizados) {
		this.noRealizados = noRealizados;
	}
	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
