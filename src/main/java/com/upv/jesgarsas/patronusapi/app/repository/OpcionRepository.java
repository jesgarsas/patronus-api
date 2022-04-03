package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Opcion;

@Repository
public interface OpcionRepository  extends JpaRepository<Opcion, Integer> {
	
	@Modifying
	void deleteByPreguntaId(Integer id);
}
