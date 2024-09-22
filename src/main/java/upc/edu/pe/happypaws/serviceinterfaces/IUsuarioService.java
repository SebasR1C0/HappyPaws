package upc.edu.pe.happypaws.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import upc.edu.pe.happypaws.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Long usuarioId);
    public List<Usuario> searchEmail(String email);
    public List<Usuario> findactivos();
    public Usuario findOneByUsername(String user);
    public Long findByUsername(@Param("user") String user);
}
