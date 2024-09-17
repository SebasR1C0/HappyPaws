package upc.edu.pe.happypaws.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.happypaws.entities.Comentario;
import upc.edu.pe.happypaws.repositories.IComentarioRepository;
import upc.edu.pe.happypaws.serviceinterfaces.IComentarioService;

import java.util.List;

@Service
public class ComentarioServiceImplement implements IComentarioService {
    @Autowired
    private IComentarioRepository comentarioRepository;


    @Override
    public List<Comentario> list() {
        return comentarioRepository.findAll();
    }

    @Override
    public void insert(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void update(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void delete(int comentarioId) {
        comentarioRepository.deleteById(comentarioId);
    }
}
