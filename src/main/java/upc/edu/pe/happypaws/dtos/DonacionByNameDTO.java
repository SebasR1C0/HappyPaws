package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonacionByNameDTO {
    private String Nombre;
    private String Apellido;
    private double MontoTotal;
}
