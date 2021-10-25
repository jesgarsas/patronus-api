package com.upv.jesgarsas.patronusapi.app.utils;

public abstract class RolTypes {

	private static String[] ROLES = {
			"",
			"Alumno",
			"Profesor",
			"Administrador"
	};
	
	public static String getRolById(Integer id) {
		return ROLES[id];
	}
}
