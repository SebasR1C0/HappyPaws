package upc.edu.pe.happypaws.serviceinterfaces;

import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int usuarioId);
    public List<Usuario> searchEmail(String email);
    public List<Usuario> findactivos();
}
