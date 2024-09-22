package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Rol;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
    @Query(value = "SELECT r.rol, COUNT(r.user_id) AS Cantidad_Usuarios" +
            " FROM Roles  r GROUP BY r.rol", nativeQuery = true)
    public List<String[]> countrol();
}
