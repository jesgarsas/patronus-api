package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Ejercicio;
import com.upv.jesgarsas.patronusapi.app.repository.interfaces.IEjercicioTable;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>,
		PagingAndSortingRepository<Ejercicio, Integer>, JpaSpecificationExecutor<Ejercicio> {

	public Page<Ejercicio> findAll(Specification<Ejercicio> spec, Pageable pageable);

	@Query(value = "SELECT ID, ID_PATRON, ID_LOCAL, NOMBRE, FECHA_CREACION as fechaCreacion, AUTOR, INTENTOS, nota, sum(CASE WHEN res_id IS NOT NULL THEN 1 ELSE 0 END) AS realizados FROM "
			+ "(SELECT e.*, r.id AS res_id, "
			+ "(r.CORRECTAS / (SELECT count(*) FROM PREGUNTA p WHERE p.ID_EJERCICIO = 1) * 10.0) AS nota "
			+ "FROM ejercicio e LEFT JOIN RESULTADO r ON r.ID_EJERCICIO = e.ID AND r.ID_USUARIO = :usuario WHERE  e.ID_PATRON = :patron) x "
			+ "GROUP BY ID, ID_PATRON, ID_LOCAL, NOMBRE, FECHA_CREACION, AUTOR, INTENTOS, nota", nativeQuery = true)
	public List<IEjercicioTable> findAllByPatronAndUsuario(@Param("patron") Integer patron,
			@Param("usuario") Integer usuario);
}
