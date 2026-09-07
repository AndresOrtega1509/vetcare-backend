package com.devsenior.vetcare.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
@Table(name = "mascotas")
public class Mascota {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la mascota no puede estar vacío")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "La especie de la mascota no puede estar vacía")
    @Column(length = 50, nullable = false)
    private String especie;

    @NotBlank(message = "La raza de la mascota no puede estar vacía")
    @Column(length = 50, nullable = false)
    private String raza;
    
    @NotBlank(message = "El sexo de la mascota no puede estar vacío")
    @Column(length = 10, nullable = false)
    private String sexo;

    @NotNull(message = "La fecha de nacimiento de la mascota no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder 
    .Default
    private List<Cita> citas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dueno_id", nullable = false)
    private Dueno dueno;
}
