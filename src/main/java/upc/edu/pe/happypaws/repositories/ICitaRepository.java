package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Cita;
import upc.edu.pe.happypaws.entities.Mascota;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    @Query(value = "SELECT * FROM public.cita m WHERE m.id_cita = :id", nativeQuery = true)
    public List<Cita> findid(@Param("id") int id);

    @Query(value = "SELECT * FROM public.cita m WHERE m.id_usuario = :id", nativeQuery = true)
    public List<Cita> findusuario(@Param("id") int id);

    @Query(value = "SELECT * FROM public.cita m WHERE m.id_albergue = :id", nativeQuery = true)
    public List<Cita> findalbergue(@Param("id") int id);

    @Query(value = "SELECT * FROM public.cita m WHERE UPPER(m.estado_cita) = 'PENDIENTE'", nativeQuery = true)
    public List<Cita> findpendiente();
}
