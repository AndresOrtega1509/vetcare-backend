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

@Entity 
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
@Builder 
@Table(name = "veterinarios")
public class Veterinario {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del veterinario no puede estar vacío")
    @Column(length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido del veterinario no puede estar vacío")
    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 20)
    private String especialidad;

    @NotBlank(message = "El número de tarjeta profesional del veterinario no puede estar vacío")
    @Column(length = 20, unique = true, nullable = false)
    private String tarjetaProfesional;

    @OneToMany(mappedBy = "veterinario")
    @Builder 
    .Default
    private List<Cita> citas = new ArrayList<>();
}
