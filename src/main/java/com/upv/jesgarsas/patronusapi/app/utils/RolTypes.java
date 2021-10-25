package com.upv.jesgarsas.patronusapi.app.utils;

public abstract class RolTypes {

	private static String[] ROLES = {
			"",
			"Alumno",
			"Profesor",
			"Administrador"
	};
	
	public static String ALUMNO = "Alumno";
	
	public static String PROFESOR = "Profesor";
	
	public static String ADMINISTRADOR = "Administrador";
	
	public static String[] getAllRoles() {
		String [] roles = new String[ROLES.length-1];
		for(int i = 1; i < ROLES.length; i++) { roles[i-1] = ROLES[i]; }
		return roles;
	}
	
	public static String getRolById(Integer id) {
		return ROLES[id];
	}
	
	public static boolean hasRol(String rol) {
		for(String _rol : ROLES) {
			if (_rol.equals(rol)) return true;
		}
		return false;
	}
}
