package upc.edu.pe.happypaws.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.happypaws.entities.Usuario;
import upc.edu.pe.happypaws.repositories.IUsuarioRepository;
import upc.edu.pe.happypaws.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public List<Usuario> searchEmail(String email) {
        return usuarioRepository.findEmail(email);
    }

    @Override
    public List<Usuario> findactivos() {
        return usuarioRepository.findactivos();
    }

    @Override
    public Usuario findOneByUsername(String user) {
        return usuarioRepository.findOneByUsername(user);
    }

    @Override
    public Long findByUsername(String user) {
        return usuarioRepository.findByUsername(user);
    }

}
