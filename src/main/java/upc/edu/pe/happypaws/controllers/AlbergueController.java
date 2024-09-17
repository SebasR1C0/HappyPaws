package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.AlbergueDTO;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.serviceinterfaces.IAlbergueService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/albergues")
public class AlbergueController {
    @Autowired
    private IAlbergueService albergueService;

    @GetMapping
    public List<AlbergueDTO> listar() {
        return albergueService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlbergueDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody AlbergueDTO albergueDTO) {
        ModelMapper m = new ModelMapper();
        Albergue albergue = m.map(albergueDTO, Albergue.class);
        albergueService.insert(albergue);
    }
    @PutMapping
    public void modificar(@RequestBody AlbergueDTO albergueDTO) {
        ModelMapper m = new ModelMapper();
        Albergue albergue = m.map(albergueDTO, Albergue.class);
        albergueService.update(albergue);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        albergueService.delete(id);
    }
}
