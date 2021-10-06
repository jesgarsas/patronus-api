package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Leccion;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Integer> {

	public Leccion findByPatronIdAndLocaleId(Integer idPatron, Integer idLocale);
	
}
