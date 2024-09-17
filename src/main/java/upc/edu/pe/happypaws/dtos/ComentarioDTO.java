package upc.edu.pe.happypaws.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.happypaws.entities.Albergue;

@Getter
@Setter
public class ComentarioDTO {
    private int IdComentario;
    private String Comentario;
    private double Estrella;
    private Albergue albergue;
}
