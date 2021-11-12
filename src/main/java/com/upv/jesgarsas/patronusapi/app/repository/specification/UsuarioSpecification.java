package com.upv.jesgarsas.patronusapi.app.repository.specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.upv.jesgarsas.patronusapi.app.model.dto.filter.UsuarioFilterDTO;
import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;
import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;

public class UsuarioSpecification implements Specification<Usuario> {
	
	private static final long serialVersionUID = 1L;
	
	public final static String NICK_COLUMNA = "nick";
	
	public final static String EMAIL_COLUMNA = "email";
	
	public final static String GRUPO_COLUMNA = "grupo";
	
	public final static String GRUPO_ID_COLUMNA = "id";
	
	public final static String ID_COLUMNA = "id";

	private UsuarioFilterDTO dto;
	
	public UsuarioSpecification(UsuarioFilterDTO dto) {
		this.dto = dto;
	}

	@Override
	public Predicate toPredicate(Root<Usuario> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		// Filtros
		if (dto.getIdGrupo() != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.join(GRUPO_COLUMNA, JoinType.INNER).<Grupo>get(GRUPO_ID_COLUMNA), dto.getIdGrupo())));
		}
		
		// Sorting
		String column = NICK_COLUMNA;
		if (dto.getColumn() == null) {}
		else if(dto.getColumn().equals(GRUPO_ID_COLUMNA) ) {
			if (("desc").equals(dto.getSort())) {
				query.orderBy(criteriaBuilder.desc(root.get(ID_COLUMNA)));
			} else {
				query.orderBy(criteriaBuilder.asc(root.get(ID_COLUMNA)));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])); 
		} else if (dto.getColumn().equals(EMAIL_COLUMNA)) {
			column = EMAIL_COLUMNA;
		}
		
		if (("desc").equals(dto.getSort())) {
			query.orderBy(criteriaBuilder.desc(root.get(column)));
		} else {
			query.orderBy(criteriaBuilder.asc(root.get(column)));
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}
}