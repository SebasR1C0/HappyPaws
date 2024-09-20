package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.NotificacionDTO;
import upc.edu.pe.happypaws.dtos.RolByUserDTO;
import upc.edu.pe.happypaws.dtos.RolDTO;
import upc.edu.pe.happypaws.entities.Rol;
import upc.edu.pe.happypaws.serviceinterfaces.IRolService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RolDTO roldto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(roldto, Rol.class);
        rolService.insert(rol);
    }
    @PutMapping
    public void modificar(@RequestBody RolDTO roldto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(roldto, Rol.class);
        rolService.update(rol);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rolService.delete(id);
    }

    @GetMapping("/rolxuser")
    public List<RolByUserDTO> rolporuser(){
        List<String[]> lista = rolService.countrol();
        List<RolByUserDTO> ListDTO = new ArrayList<>();
        for (String[] columna:lista) {
            RolByUserDTO dto = new RolByUserDTO();
            dto.setNombreRol(columna[0]);
            dto.setCount(Integer.parseInt(columna[1]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
}
