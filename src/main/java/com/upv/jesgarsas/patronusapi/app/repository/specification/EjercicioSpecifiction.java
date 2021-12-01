package com.upv.jesgarsas.patronusapi.app.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.upv.jesgarsas.patronusapi.app.model.dto.filter.EjercicioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;

public class EjercicioSpecifiction implements Specification<Ejercicio> {
	
	private static final long serialVersionUID = 1L;
	
	public final static String NOMBRE_COLUMNA = "nombre";
	
	public final static String FECHACREACION_COLUMNA = "fechaCreacion";

	public final static String AUTOR_COLUMNA = "profesor";
	
	public final static String AUTOR_NICK_COLUMNA = "nick";
	
	private EjercicioFilterDTO dto;

	public EjercicioSpecifiction(EjercicioFilterDTO dto) {
		this.dto = dto;
	}

	@Override
	public Predicate toPredicate(Root<Ejercicio> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		// Filtros
				if (dto.getNombre() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get(NOMBRE_COLUMNA)), "%" + dto.getNombre().toLowerCase() + "%")));
				}
				if (dto.getProfesor() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get(AUTOR_COLUMNA).get(AUTOR_NICK_COLUMNA)), "%" + dto.getProfesor().toLowerCase() + "%")));
				}
				dto.addTimeToDateFin();
				if (dto.getDateIni() != null && dto.getDateFin() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get(FECHACREACION_COLUMNA), dto.getDateIni(), (dto.getDateFin()))));
				} else if (dto.getDateIni() != null){
					predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get(FECHACREACION_COLUMNA), dto.getDateIni())));
				} else if (dto.getDateFin() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get(FECHACREACION_COLUMNA), dto.getDateFin())));
				}
				// Sorting
				String column = NOMBRE_COLUMNA;
				if(dto.getColumn() == null) { }
				else if (dto.getColumn().equals(FECHACREACION_COLUMNA)) {
					column = FECHACREACION_COLUMNA;
				} else if (dto.getColumn().equals(AUTOR_COLUMNA)) {
					column = AUTOR_COLUMNA;
				}
				
				if (("asc").equals(dto.getSort())) {
					query.orderBy(criteriaBuilder.asc(root.get(column)));
				} else {
					query.orderBy(criteriaBuilder.desc(root.get(column)));
				}

		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}
}
