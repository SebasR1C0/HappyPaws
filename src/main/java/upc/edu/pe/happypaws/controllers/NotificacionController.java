package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.MascotaDTO;
import upc.edu.pe.happypaws.dtos.NotificacionByDateDTO;
import upc.edu.pe.happypaws.dtos.NotificacionDTO;
import upc.edu.pe.happypaws.dtos.RolByUserDTO;
import upc.edu.pe.happypaws.entities.Notificacion;
import upc.edu.pe.happypaws.serviceinterfaces.INotificacionService;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @GetMapping("/notificacionxfecha")
    public List<NotificacionByDateDTO> notificacionporfecha(@RequestParam("fecha") LocalDate fecha){
        List<String[]> lista = notificacionService.notifiacionxfecha(fecha);
        List<NotificacionByDateDTO> ListDTO = new ArrayList<>();
        for (String[] columna:lista) {
            NotificacionByDateDTO dto = new NotificacionByDateDTO();
            dto.setNombre(columna[0]);
            dto.setApellido(columna[1]);
            dto.setCantidad(Integer.parseInt(columna[2]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
}
