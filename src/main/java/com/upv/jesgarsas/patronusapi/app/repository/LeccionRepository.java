package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Leccion;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Integer> {

	public Set<Leccion> findAllByPatronIdAndLocaleId(Integer idPatron, Integer idLocale);
	
}
