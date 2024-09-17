package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.AlbergueDTO;
import upc.edu.pe.happypaws.dtos.CitaDTO;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.entities.Cita;
import upc.edu.pe.happypaws.serviceinterfaces.ICitaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("citas")
public class CitaController {
    @Autowired
    private ICitaService citaService;

    @GetMapping
    public List<CitaDTO> listar() {
        return citaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CitaDTO citaDTO) {
        ModelMapper m = new ModelMapper();
        Cita cita = m.map(citaDTO, Cita.class);
        citaService.insert(cita);
    }
    @PutMapping
    public void modificar(@RequestBody CitaDTO citaDTO) {
        ModelMapper m = new ModelMapper();
        Cita cita = m.map(citaDTO, Cita.class);
        citaService.update(cita);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        citaService.delete(id);
    }
}
