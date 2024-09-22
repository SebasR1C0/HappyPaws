package upc.edu.pe.happypaws.dtos;


import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Rol;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String Email;
    private String Genero;
    private LocalDate FechaRegistro;
    private Boolean enabled;
    private String username;
    private String password;
}
