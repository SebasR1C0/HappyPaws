package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Cita;
import upc.edu.pe.happypaws.entities.Donacion;

import java.util.List;

@Repository
public interface IDonacionRepository extends JpaRepository<Donacion, Integer> {
    @Query(value = "SELECT * FROM public.donacion d WHERE d.id_usuario = :id", nativeQuery = true)
    public List<Donacion> findusuario(@Param("id") int id);

    @Query(value = "SELECT * FROM public.donacion d ORDER BY d.monto DESC", nativeQuery = true)
    public List<Donacion> findmontos();
}
