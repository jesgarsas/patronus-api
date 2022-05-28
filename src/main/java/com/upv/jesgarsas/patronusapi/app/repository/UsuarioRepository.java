package com.upv.jesgarsas.patronusapi.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

	@Query(value = "SELECT id, nick, email, rol_id, last_patron, null as password FROM Usuario WHERE nick = :nick AND password = :password", nativeQuery = true)
	public Usuario findByNickAndPassword(String nick, String password);
	
	@Query(value = "SELECT id, nick, email, rol_id, last_patron, null as password FROM Usuario WHERE id = :id", nativeQuery = true)
	public Usuario findByIdWithoutPassword(Integer id);

	@Query(value = "SELECT id, nick, email, rol_id, last_patron, null as password FROM Usuario WHERE rol_id = :type", nativeQuery = true)
	public List<Usuario> findByRolId(Integer type);

	@Query(value = "SELECT id, nick, email, rol_id, last_patron, null as password FROM Usuario WHERE rol_id in :types", nativeQuery = true)
	public List<Usuario> findByRolIdIn(List<Integer> types);
	
	public Page<Usuario> findAll(Specification<Usuario> spec, Pageable pageable);

	@Modifying
	@Query(value = "UPDATE Usuario SET NICK = :nick, EMAIL = :email WHERE ID = :id", nativeQuery = true)
	public void edit(Integer id, String nick, String email);
	
	@Query(value = "SELECT g.ID FROM GRUPO g WHERE g.ID_PROFESOR = :id AND EXISTS(SELECT * FROM R_GRUPO_ALUMNO rga WHERE rga.ID_GRUPO = g.ID)", nativeQuery = true)
	public List<Integer> findGruposByUser(@Param("id") Integer id);
}
