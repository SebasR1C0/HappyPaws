package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.AlbergueDTO;
import upc.edu.pe.happypaws.dtos.ComentarioDTO;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.entities.Comentario;
import upc.edu.pe.happypaws.serviceinterfaces.IComentarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private IComentarioService comentarioService;

    @GetMapping
    public List<ComentarioDTO> listar() {
        return comentarioService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComentarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);
        comentarioService.insert(comentario);
    }
    @PutMapping
    public void modificar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);
        comentarioService.update(comentario);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        comentarioService.delete(id);
    }
}
