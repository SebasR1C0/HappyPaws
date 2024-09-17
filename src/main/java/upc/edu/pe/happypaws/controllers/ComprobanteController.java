package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.ComprobanteDTO;
import upc.edu.pe.happypaws.entities.Comprobante;
import upc.edu.pe.happypaws.serviceinterfaces.IComprobanteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {
    @Autowired
    private IComprobanteService comprobanteService;

    @GetMapping
    public List<ComprobanteDTO> listar() {
        return comprobanteService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ComprobanteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ComprobanteDTO comprobanteDTO) {
        ModelMapper m = new ModelMapper();
        Comprobante comprobante = m.map(comprobanteDTO, Comprobante.class);
        comprobanteService.insert(comprobante);
    }
    @PutMapping
    public void modificar(@RequestBody ComprobanteDTO comprobanteDTO) {
        ModelMapper m = new ModelMapper();
        Comprobante comprobante = m.map(comprobanteDTO, Comprobante.class);
        comprobanteService.update(comprobante);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        comprobanteService.delete(id);
    }
}
