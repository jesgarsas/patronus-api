package com.upv.jesgarsas.patronusapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.upv.jesgarsas.patronusapi.app.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

	@Modifying
	@Query(value = "UPDATE Usuario SET LAST_PATRON = NULL WHERE LAST_PATRON = :id", nativeQuery = true)
	public void updateLastPatronToNull(@Param("id") Integer id);

	@Query(value = "SELECT id, nick, email, rol_id, last_patron FROM Usuario WHERE nick = :nick AND password = :password", nativeQuery = true)
	public Usuario findByNickAndPassword(String nick, String password);
	
	@Query(value = "SELECT id, nick, email, rol_id, last_patron FROM Usuario WHERE id = :id", nativeQuery = true)
	public Usuario findByIdWithoutPassword(Integer id);

}
