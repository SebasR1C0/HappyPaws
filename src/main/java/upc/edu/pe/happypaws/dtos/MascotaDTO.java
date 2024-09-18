package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Albergue;

import java.time.LocalDate;

@Getter
@Setter
public class MascotaDTO {
    private int IdMascota;
    private String NombreMascota;
    private LocalDate NacimientoMascota;
    private String RazaMascota;
    private String SexoMascota;
    private String EstadoMascota;
    private LocalDate FechaIngresoMascota;
    private boolean EstadoAdopcion;
    private Albergue Albergue;
}
