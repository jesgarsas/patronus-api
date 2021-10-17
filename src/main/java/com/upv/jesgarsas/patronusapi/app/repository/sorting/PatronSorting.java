package com.upv.jesgarsas.patronusapi.app.repository.sorting;

import org.springframework.data.domain.Sort;

import com.upv.jesgarsas.patronusapi.app.model.dto.PatronFilterDTO;

public class PatronSorting {

	public final static String NOMBRE_COLUMNA = "nombre";
	
	public final static String FECHACREACION_COLUMNA = "fecha_creacion";

	public final static String AUTOR_COLUMNA = "autor";
	
	public static Sort getSorting(PatronFilterDTO filter) {
		String column;
		if (filter.getColumn() == null) return Sort.by(NOMBRE_COLUMNA).ascending();
		if (filter.getColumn().equals(NOMBRE_COLUMNA)) {
			column = NOMBRE_COLUMNA;
		} else if (filter.getColumn().equals(FECHACREACION_COLUMNA)) {
			column = FECHACREACION_COLUMNA;
		} else if (filter.getColumn().equals(AUTOR_COLUMNA)) {
			column = AUTOR_COLUMNA;
		} else { return Sort.by(NOMBRE_COLUMNA).ascending(); }
		
		if (filter.getSort().equals("asc")) {
			return Sort.by(column).ascending();
		} else {
			return Sort.by(column).descending();
		}
	}
}
