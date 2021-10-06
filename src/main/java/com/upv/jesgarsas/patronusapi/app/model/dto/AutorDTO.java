package com.upv.jesgarsas.patronusapi.app.model.dto;

import java.io.Serializable;

public class AutorDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nick;

	public AutorDTO() {}

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
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
}
