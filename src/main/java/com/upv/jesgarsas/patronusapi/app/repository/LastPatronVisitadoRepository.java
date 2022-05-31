package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.LastPatronVisitado;
import com.upv.jesgarsas.patronusapi.app.model.entity.pk.LastPatronVisitadoPK;

@Repository
public interface LastPatronVisitadoRepository extends JpaRepository<LastPatronVisitado, LastPatronVisitadoPK> {

	public List<LastPatronVisitado> findByIdIdUsuarioOrderByFechaDesc(Integer id);
}
