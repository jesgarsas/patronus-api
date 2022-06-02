package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upv.jesgarsas.patronusapi.app.model.entity.Resultado;
import com.upv.jesgarsas.patronusapi.app.repository.interfaces.IEstadisticaPregunta;
import com.upv.jesgarsas.patronusapi.app.repository.interfaces.ILastEjercicio;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {

	@Query(nativeQuery = true, value = "SELECT max(r.INTENTO) FROM RESULTADO r WHERE r.ID_USUARIO = :idUser AND r.ID_EJERCICIO = :idEjercicio")
	public Integer getMaxIntento(@Param("idUser") Integer idUser, @Param("idEjercicio") Integer idEjercicio);
	
	public List<Resultado> findByIdUsuarioAndIdEjercicioAndIntento(Integer idUsuario, Integer idEjercicio, Integer intento);
	
	@Query(nativeQuery = true, value = "SELECT x.id_pregunta AS id, CASE WHEN x.MARCADA = o.CORRECTA THEN 1 ELSE 0 END AS correcta, x.fecha "
			+ "FROM (SELECT r.*, RANK() OVER (PARTITION BY r.ID_EJERCICIO, r.ID_USUARIO, r.ID_PREGUNTA, r.ID_OPCION ORDER BY r.INTENTO desc) rank  "
			+ "FROM RESULTADO r) x LEFT JOIN USUARIO u ON u.ID = x.ID_USUARIO INNER JOIN R_GRUPO_ALUMNO rga ON rga.ID_USUARIO = u.id  "
			+ "LEFT JOIN OPCION o ON o.ID = x.ID_OPCION "
			+ "WHERE x.ID_EJERCICIO = :idEjercicio AND rga.ID_GRUPO = :idGrupo AND RANK = 1 AND x.ID_USUARIO = :idUsuario")
	public List<IEstadisticaPregunta> findByIdUsuarioAndIdEjercicioAndIntentoAndLast(@Param("idUsuario") Integer idUsuario, @Param("idEjercicio") Integer idEjercicio,
			@Param("idGrupo") Integer idGrupo);
	
	@Query(nativeQuery = true, value = "SELECT r2.ID_EJERCICIO as ejercicioId, r2.FECHA, e.NOMBRE, INTENTO FROM RESULTADO r2 LEFT JOIN EJERCICIO e ON e.ID = r2.ID_EJERCICIO WHERE r2.FECHA = (SELECT max(FECHA) FROM RESULTADO r WHERE r.ID_USUARIO = :usuario)"
			+ "	AND ID_USUARIO = :usuario  AND rownum = 1")
	public ILastEjercicio findLastEjercicioId(@Param("usuario") Integer idUsuario);
	
	@Query(nativeQuery = true, value = "SELECT count(*) FROM EJERCICIO e WHERE EXISTS (SELECT * FROM RESULTADO r WHERE r.ID_EJERCICIO = e.ID AND r.ID_USUARIO = :usuario)")
	public Integer findCountEjerciciosResueltos(@Param("usuario") Integer idUsuario);
	
	@Query(nativeQuery = true, value = "SELECT count(*) FROM EJERCICIO e WHERE NOT EXISTS (SELECT * FROM RESULTADO r WHERE r.ID_EJERCICIO = e.ID AND r.ID_USUARIO = :usuario)")
	public Integer findCountEjerciciosNoResueltos(@Param("usuario") Integer idUsuario);
}
