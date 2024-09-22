package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    @Transactional
    @Modifying
    @Query(value = "Select * from public.users u where u.Email = :email", nativeQuery = true)
    public List<Usuario> findEmail(@Param("email") String email);

    @Query(value = "Select * from public.users u where u.username = :user", nativeQuery = true)
    public Usuario findOneByUsername(@Param("user") String user);

    @Query(value = "Select u.id from public.users u where u.username = :user", nativeQuery = true)
    public Long findByUsername(@Param("user") String user);

    @Query(value = "Select * from public.users u where u.enabled = 'true'", nativeQuery = true)
    public List<Usuario> findactivos();
}
