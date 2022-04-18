package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

	@Modifying
	void deleteByEjercicioId(Integer id);
	
	@Modifying
	void deleteByIdIn(List<Integer> id);
	
	@Query(value = "SELECT P.id FROM Pregunta as P WHERE P.ejercicio.id = :idEjercicio")
	List<Integer> findIdsByEjercicioId(@Param("idEjercicio") Integer idEjercicio);
}
