package com.upv.jesgarsas.patronusapi.app.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.upv.jesgarsas.patronusapi.app.model.dto.filter.GrupoFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;


public class GrupoSpecification implements Specification<Grupo> {
	
	private static final long serialVersionUID = 1L;
	
	public final static String NOMBRE_COLUMNA = "nombre";
	
	public final static String PROFESOR_COLUMNA = "profesor";
	
	public final static String PROFESOR_NICK_COLUMNA = "nick";
	
	public final static String N_ALUMNOS_COLUMNA = "alumnosCount";
	
	public final static String ID_COLUMNA = "id";
	
	private GrupoFilterDTO dto;
	
	public GrupoSpecification(GrupoFilterDTO dto) {
		this.dto = dto;
	}

	@Override
	public Predicate toPredicate(Root<Grupo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		// Filtros
		if (dto.getNombre() != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get(NOMBRE_COLUMNA)), "%" + dto.getNombre().toLowerCase() + "%")));
		}
		if (dto.getProfesor() != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get(PROFESOR_COLUMNA).get(PROFESOR_NICK_COLUMNA)), "%" + dto.getProfesor().toLowerCase() + "%")));
		}
		
		// Sorting
		String column = NOMBRE_COLUMNA;
		if(dto.getColumn() == null) { }
		else if (dto.getColumn().equals(PROFESOR_COLUMNA)) {
			column = PROFESOR_COLUMNA;
		}
		
		if (("asc").equals(dto.getSort())) {
			query.orderBy(criteriaBuilder.asc(root.get(column)));
		} else {
			query.orderBy(criteriaBuilder.desc(root.get(column)));
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}