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

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer>,
		PagingAndSortingRepository<Ejercicio, Integer>, JpaSpecificationExecutor<Ejercicio> {

	public Page<Ejercicio> findAll(Specification<Ejercicio> spec, Pageable pageable);

	@Query(value = "SELECT (SELECT count(*) FROM RESULTADO r WHERE r.ID_EJERCICIO = e.ID AND  r.ID_USUARIO = :usuario) AS num_realizado, e.* FROM EJERCICIO e "
			+ "WHERE e.ID_PATRON = :patron", nativeQuery = true)
	public List<Ejercicio> findAllByPatronAndUsuario(@Param("patron") Integer patron,
			@Param("usuario") Integer usuario);
}
