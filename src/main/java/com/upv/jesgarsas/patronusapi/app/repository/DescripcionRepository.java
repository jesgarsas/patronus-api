package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Descripcion;

@Repository
public interface DescripcionRepository extends JpaRepository<Descripcion, Integer>{
	
	public Descripcion findByPatronIdAndLocaleId(Integer idPatron, Integer idLocale);
}
