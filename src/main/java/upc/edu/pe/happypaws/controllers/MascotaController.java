package upc.edu.pe.happypaws.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.happypaws.dtos.DonacionDTO;
import upc.edu.pe.happypaws.dtos.MascotaDTO;
import upc.edu.pe.happypaws.dtos.UsuarioDTO;
import upc.edu.pe.happypaws.entities.Donacion;
import upc.edu.pe.happypaws.entities.Mascota;
import upc.edu.pe.happypaws.serviceinterfaces.IMascotaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    @Autowired
    private IMascotaService mascotaService;

    @GetMapping
    public List<MascotaDTO> listar() {
        return mascotaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MascotaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MascotaDTO mascotaDTO) {
        ModelMapper m = new ModelMapper();
        Mascota mascota = m.map(mascotaDTO, Mascota.class);
        mascotaService.insert(mascota);
    }
    @PutMapping
    public void modificar(@RequestBody MascotaDTO mascotaDTO) {
        ModelMapper m = new ModelMapper();
        Mascota mascota = m.map(mascotaDTO, Mascota.class);
        mascotaService.update(mascota);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        mascotaService.delete(id);
    }
    @GetMapping("/buscarxestado")
    public List<MascotaDTO> noadoptados(@RequestParam("estado") boolean estado){
        return mascotaService.mascotasestado(estado).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MascotaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarxraza")
    public List<MascotaDTO> buscarporraza(@RequestParam("raza") String raza){
        return mascotaService.mascotasrazas(raza).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MascotaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarxsexo")
    public List<MascotaDTO> buscarporsexo(@RequestParam("sexo") String sexo){
        return mascotaService.mascotassexo(sexo).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MascotaDTO.class);
        }).collect(Collectors.toList());
    }
}
