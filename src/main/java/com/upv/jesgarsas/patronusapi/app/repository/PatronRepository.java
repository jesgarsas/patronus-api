package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Integer>,  PagingAndSortingRepository<Patron, Integer> {

	public Page<Patron> findAll(Pageable pageable);
}
