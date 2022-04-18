package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Opcion;

@Repository
public interface OpcionRepository  extends JpaRepository<Opcion, Integer> {
	
	@Modifying
	void deleteByPreguntaId(Integer id);
	
	@Modifying
	void deleteByIdIn(List<Integer> id);
	
	@Query(value = "SELECT O.id FROM Opcion as O WHERE O.pregunta.id = :idPregunta")
	List<Integer> findIdsByPreguntaId(@Param("idPregunta") Integer idPregunta);
}
