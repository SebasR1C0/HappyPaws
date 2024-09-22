package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody UsuarioDTO usuariodto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(usuariodto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        usuarioService.insert(u);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody UsuarioDTO usuariodto) {
        ModelMapper m = new ModelMapper();
        Usuario ro = m.map(usuariodto, Usuario.class);
        usuarioService.update(ro);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Long id){
        usuarioService.delete(id);
    }

    @GetMapping("/recuperar")
    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public List<UsuarioDTO> recuperar(@RequestParam("email") String email){
        return usuarioService.searchEmail(email).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/activos")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UsuarioDTO> activos(){
        return usuarioService.findactivos().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
