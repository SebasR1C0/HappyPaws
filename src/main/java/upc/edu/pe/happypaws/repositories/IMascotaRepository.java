package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Mascota;

import java.util.List;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {
    @Query(value = "SELECT * FROM public.mascota m WHERE m.estado_adopcio = :estado", nativeQuery = true)
    public List<Mascota> findestado(@Param("estado") boolean estado);

    @Query(value = "SELECT * FROM public.mascota m WHERE m.raza_mascota = :raza", nativeQuery = true)
    public List<Mascota> findraza(@Param("raza") String raza);

    @Query(value = "SELECT * FROM public.mascota m WHERE m.sexo_mascota = :sexo", nativeQuery = true)
    public List<Mascota> findsexo(@Param("sexo") String sexo);
}
