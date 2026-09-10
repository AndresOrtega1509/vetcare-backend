package com.devsenior.vetcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VeterinarioRequestDTO(
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    String nombre,
    
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    String apellido,

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(min = 3, max = 20, message = "La especialidad debe tener entre 3 y 20 caracteres")
    String especialidad,

    @NotBlank(message = "La tarjeta profesional es obligatoria")
    @Size(min = 3, max = 20, message = "La tarjeta profesional debe tener entre 3 y 20 caracteres")
    String tarjetaProfesional
) {}
