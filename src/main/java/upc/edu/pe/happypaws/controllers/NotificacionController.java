package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.MascotaDTO;
import upc.edu.pe.happypaws.dtos.NotificacionDTO;
import upc.edu.pe.happypaws.entities.Notificacion;
import upc.edu.pe.happypaws.serviceinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService notificacionService;

    @GetMapping
    public List<NotificacionDTO> listar() {
        return notificacionService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NotificacionDTO notificacionDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion notifiacion = m.map(notificacionDTO, Notificacion.class);
        notificacionService.insert(notifiacion);
    }
    @PutMapping
    public void modificar(@RequestBody NotificacionDTO notificacionDTO) {
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(notificacionDTO, Notificacion.class);
        notificacionService.update(notificacion);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        notificacionService.delete(id);
    }
    @GetMapping("/buscarxemisor")
    public List<NotificacionDTO> buscarporemisor(@RequestParam("id") int id){
        return notificacionService.findemisor(id).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarxrecepetor")
    public List<NotificacionDTO> buscarporreceptor(@RequestParam("id") int id){
        return notificacionService.findreceptor(id).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
}
