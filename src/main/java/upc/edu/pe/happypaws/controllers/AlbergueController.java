package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.AlbergueByCountDTO;
import upc.edu.pe.happypaws.dtos.AlbergueDTO;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.serviceinterfaces.IAlbergueService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/albergues")
public class AlbergueController {
    @Autowired
    private IAlbergueService albergueService;

    @GetMapping

    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public List<AlbergueDTO> listar() {
        return albergueService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlbergueDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ALBERGUE')")
    public void insertar(@RequestBody AlbergueDTO albergueDTO) {
        ModelMapper m = new ModelMapper();
        Albergue albergue = m.map(albergueDTO, Albergue.class);
        albergueService.insert(albergue);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ALBERGUE')")
    public void modificar(@RequestBody AlbergueDTO albergueDTO) {
        ModelMapper m = new ModelMapper();
        Albergue albergue = m.map(albergueDTO, Albergue.class);
        albergueService.update(albergue);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){
        albergueService.delete(id);
    }
    @GetMapping("/buscarxnombre")
    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public List<AlbergueDTO> buscarpornombre(@RequestParam("name") String name){
        return albergueService.findalbergue(name).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AlbergueDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/alberguexcantidad")
    @PreAuthorize("hasAuthority('ALBERGUE') or hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public List<AlbergueByCountDTO> albergueporcantidad(){
        List<String[]> lista = albergueService.albergueporcantidad();
        List<AlbergueByCountDTO> ListDTO = new ArrayList<>();
        for (String[] columna:lista) {
            AlbergueByCountDTO dto = new AlbergueByCountDTO();
            dto.setNombreAlbergue(columna[0]);
            dto.setCapacidad(Integer.parseInt(columna[1]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }

    @GetMapping("/abiertoahora")
    @PreAuthorize("hasAuthority('CLIENTE') OR hasAuthority('ADMINISTRADOR')")
    public List<AlbergueDTO> abiertoahora(){
        return albergueService.AbiertoAhora().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AlbergueDTO.class);
        }).collect(Collectors.toList());
    }
}
