package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Mascota;
import upc.edu.pe.happypaws.entities.Notificacion;

import java.util.List;

@Repository
public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
    @Query(value = "SELECT * FROM public.notificacion n WHERE n.id_emisor = :id", nativeQuery = true)
    public List<Notificacion> findemisor(@Param("id") int id);

    @Query(value = "SELECT * FROM public.notificacion n WHERE n.id_usuario = :id", nativeQuery = true)
    public List<Notificacion> findreceptor(@Param("id") int id);

}
