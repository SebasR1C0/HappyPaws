package upc.edu.pe.happypaws.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;

    @Column(name = "Nombre",length = 40,nullable = false)
    private String Nombre;

    @Column(name = "Apellido",length = 40,nullable = false)
    private String Apellido;

    @Column(name = "Direccion",length = 40,nullable = false)
    private String Direccion;

    @Column(name = "Telefono",length = 40,nullable = false)
    private String Telefono;

    @Column(name = "Email",length = 40,nullable = false)
    private String Email;

    @Column(name = "Genero",length = 40,nullable = false)
    private String Genero;

    @Column(name = "FechaRegistro",nullable = false)
    private LocalDate FechaRegistro;

    @Column(name = "Usuario",length = 40,nullable = false)
    private String Usuario;

    @Column(name = "Password",length = 40,nullable = false)
    private String Password;

    @Column(name = "EstadoUsuari",length = 40,nullable = false)
    private String EstadoUsuario;

    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;
}
