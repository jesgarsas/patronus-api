package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
}
