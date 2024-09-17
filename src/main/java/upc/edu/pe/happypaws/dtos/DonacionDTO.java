package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonacionDTO {
    private int IdDonacion;
    private LocalDate FechaDonacion;
    private String TipoDonacion;
    private double Monto;
    private String Detalles;
    private upc.edu.pe.happypaws.entities.Usuario Usuario;
}
