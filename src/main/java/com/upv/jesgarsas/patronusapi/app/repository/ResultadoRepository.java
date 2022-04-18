package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upv.jesgarsas.patronusapi.app.model.entity.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {

	@Query(nativeQuery = true, value = "SELECT max(r.INTENTO) FROM RESULTADO r WHERE r.ID_USUARIO = :idUser AND r.ID_EJERCICIO = :idEjercicio")
	public Integer getMaxIntento(@Param("idUser") Integer idUser, @Param("idEjercicio") Integer idEjercicio);
	
	public List<Resultado> findByIdUsuarioAndIdEjercicioAndIntento(Integer idUsuario, Integer idEjercicio, Integer intento);
}
