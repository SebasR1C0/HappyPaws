package upc.edu.pe.happypaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.happypaws.entities.Comentario;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
}
