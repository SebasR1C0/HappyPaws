package upc.edu.pe.happypaws.dtos;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class AlbergueDTO {
    private int IdAlbergue;
    private String NombreAlbergue;
    private String DireccionAlbergue;
    private String TelefonoAlbergue;
    private String EmailAlbergue;
    private int CapacidadMaxima;
    private int HoraApertura;
    private int HoraCierre;
    private String WebSite;
    private String AcreditacionAlbergue;
}
