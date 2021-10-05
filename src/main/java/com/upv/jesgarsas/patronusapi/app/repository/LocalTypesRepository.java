package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.LocalTypes;

@Repository
public interface LocalTypesRepository extends JpaRepository<LocalTypes, Long> {

	public LocalTypes findById(Integer id);
}
