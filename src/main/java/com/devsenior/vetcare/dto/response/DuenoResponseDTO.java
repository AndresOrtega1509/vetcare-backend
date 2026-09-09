package com.devsenior.vetcare.dto.response;

import lombok.Builder;

@Builder 
public record DuenoResponseDTO(
    Long id,
    String nombre,
    String apellido,
    String documento,
    String telefono,
    String email
) {}
