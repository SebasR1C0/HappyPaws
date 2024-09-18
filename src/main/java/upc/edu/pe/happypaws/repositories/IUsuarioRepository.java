package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "Select * from public.usuario u where u.Email = :email", nativeQuery = true)
    public List<Usuario> findEmail(@Param("email") String email);

    @Query(value = "Select * from public.usuario u where UPPER(u.estado_usuari) = 'ACTIVO'", nativeQuery = true)
    public List<Usuario> findactivos();
}
