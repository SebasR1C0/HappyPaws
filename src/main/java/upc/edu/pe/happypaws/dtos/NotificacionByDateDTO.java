package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NotificacionByDateDTO {
    private String Nombre;
    private String Apellido;
    private int Cantidad;
}
