package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Rol;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "SELECT r.nombre_rol, COUNT(u.id_usuario) AS Cantidad_Usuarios\n" +
            " FROM Usuario u JOIN Rol r \n" +
            " ON u.id_rol = r.id_rol GROUP BY r.nombre_rol;", nativeQuery = true)
    public List<String[]> countrol();
}
