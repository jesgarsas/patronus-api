package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Grupo;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

	public Grupo findByAlumnosId(Integer id);

	public List<Grupo> findAllByProfesorId(Integer id);
}
