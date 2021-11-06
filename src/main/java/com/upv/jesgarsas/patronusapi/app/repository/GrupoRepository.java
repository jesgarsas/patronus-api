package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer>, PagingAndSortingRepository<Grupo, Integer>, JpaSpecificationExecutor<Grupo> {

	public Grupo findByAlumnosId(Integer id);

	public List<Grupo> findAllByProfesorId(Integer id);
	
	public Page<Grupo> findAll(Specification<Grupo> spec, Pageable pageable);
}
