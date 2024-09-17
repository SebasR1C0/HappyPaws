package upc.edu.pe.happypaws.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Albergue;
import upc.edu.pe.happypaws.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CitaDTO {
    private int IdCita;
    private LocalDate FechaCita;
    private int HoraCita;
    private String EstadoCita;
    private String TipoCita;
    private String ComentarioCita;
    private upc.edu.pe.happypaws.entities.Albergue Albergue;
    private upc.edu.pe.happypaws.entities.Usuario Usuario;
}
