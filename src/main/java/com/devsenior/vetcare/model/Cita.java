package com.devsenior.vetcare.model;

import java.time.LocalDateTime;

import com.devsenior.vetcare.model.enums.EstadoCita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "citas")
public class Cita {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El motivo de la cita no puede estar vacío")   
    @Column(length = 255, nullable = false)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotNull(message = "El costo de la cita no puede ser nulo")
    @Column(nullable = false)
    private Double costo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estadoCita;

    @ManyToOne 
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;

    @ManyToOne 
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;
}
