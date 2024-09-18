package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Albergue;

import java.util.List;

@Repository
public interface IAlbergueRepository extends JpaRepository<Albergue, Integer> {
    @Query(value = "SELECT * FROM public.albergue a WHERE a.nombre_albergue like %:nombre%", nativeQuery = true)
    public List<Albergue> findname(@Param("nombre") String nombre);
}
