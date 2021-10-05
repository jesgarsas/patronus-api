package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

}
