package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.DonacionDTO;
import upc.edu.pe.happypaws.dtos.NotificacionDTO;
import upc.edu.pe.happypaws.entities.Donacion;
import upc.edu.pe.happypaws.entities.Notificacion;
import upc.edu.pe.happypaws.serviceinterfaces.IDonacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/donaciones")
public class DonacionController {
    @Autowired
    private IDonacionService donacionService;

    @GetMapping
    public List<DonacionDTO> listar() {
        return donacionService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DonacionDTO donacionDTO) {
        ModelMapper m = new ModelMapper();
        Donacion donacion = m.map(donacionDTO, Donacion.class);
        donacionService.insert(donacion);
    }
    @PutMapping
    public void modificar(@RequestBody DonacionDTO donacionDTO) {
        ModelMapper m = new ModelMapper();
        Donacion donacion = m.map(donacionDTO, Donacion.class);
        donacionService.update(donacion);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        donacionService.delete(id);
    }
}
