package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.UsuarioDTO;
import upc.edu.pe.happypaws.entities.Usuario;
import upc.edu.pe.happypaws.serviceimplements.UsuarioServiceImplement;
import upc.edu.pe.happypaws.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO usuariodto) {
        ModelMapper m = new ModelMapper();
        Usuario ro = m.map(usuariodto, Usuario.class);
        usuarioService.insert(ro);
    }
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO usuariodto) {
        ModelMapper m = new ModelMapper();
        Usuario ro = m.map(usuariodto, Usuario.class);
        usuarioService.update(ro);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        usuarioService.delete(id);
    }
}
