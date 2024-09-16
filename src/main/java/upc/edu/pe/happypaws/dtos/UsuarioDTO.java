package upc.edu.pe.happypaws.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Rol;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {
    private int IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String Genero;
    private LocalDate FechaRegistro;
    private String EstadoUsuario;
    private String Usuario;
    private String Password;
    private Rol rol;
}
