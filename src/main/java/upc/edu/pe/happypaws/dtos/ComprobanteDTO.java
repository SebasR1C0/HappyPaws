package upc.edu.pe.happypaws.dtos;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Donacion;

@Getter
@Setter
public class ComprobanteDTO {
    private int IdComprobante;
    private String MetodoPago;
    private String EstadoComprobante;
    private Donacion donacion;
}
