package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NotificacionDTO {
    private int IdNotificacion;
    private String Mensaje;
    private int IdEmisor;
    private String Tipo;
    private LocalDate FechaEnvio;
    private upc.edu.pe.happypaws.entities.Usuario Usuario;
}
