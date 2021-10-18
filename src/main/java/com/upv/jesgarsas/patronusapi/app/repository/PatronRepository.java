package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Integer>,  PagingAndSortingRepository<Patron, Integer>, JpaSpecificationExecutor<Patron> {

	public Page<Patron> findAll(Specification<Patron> spec, Pageable pageable);
}
