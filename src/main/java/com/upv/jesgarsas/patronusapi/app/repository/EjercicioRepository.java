package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;

@Repository
public interface EjercicioRepository  extends JpaRepository<Ejercicio, Integer>, PagingAndSortingRepository<Ejercicio, Integer>, JpaSpecificationExecutor<Ejercicio> {

	public Page<Ejercicio> findAll(Specification<Ejercicio> spec, Pageable pageable);
}
