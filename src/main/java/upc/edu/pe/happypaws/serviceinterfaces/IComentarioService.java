package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Comentario;

import java.util.List;

public interface IComentarioService {
    public List<Comentario> list();
    public void insert(Comentario comentario);
    public void update(Comentario comentario);
    public void delete(int comentarioId);
    public List<Comentario> findname(String name);
}
