package com.devsenior.vetcare.dto.response;

import lombok.Builder;

@Builder 
public record VeterinarioResponseDTO(
    Long id,
    String nombre,
    String apellido,
    String especialidad,
    String tarjetaProfesional
) {}
