package upc.edu.pe.happypaws.dtos;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Usuario;

@Getter
@Setter
public class RolDTO {
    private Long id;
    private String rol;
    private Usuario user;
}
