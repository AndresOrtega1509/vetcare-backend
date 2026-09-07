package com.devsenior.vetcare.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa a un dueño de una mascota en el sistema.
 */
@Entity 
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Builder 
@Table(name = "duenos")
public class Dueno {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del dueño no puede estar vacío")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El apellido del dueño no puede estar vacío")
    @Column(nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "El documento del dueño no puede estar vacío")
    @Column(nullable = false, length = 20, unique = true)
    private String documento;

    @Column(length = 20)
    private String telefono;

    @NotBlank(message = "El email del dueño no puede estar vacío")
    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder
    .Default
    private List<Mascota> perros = new ArrayList<>();
}
