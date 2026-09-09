package com.devsenior.vetcare.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DuenoRequestDTO(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    String apellido,

    @NotBlank(message = "El documento es obligatorio")
    @Pattern(regexp = "^[0-9]{3,10}$", message = "El documento debe tener entre 3 y 10 dígitos numéricos")
    String documento,

    @Pattern(regexp = "^([0-9]{10})?$", message = "El telefono debe tener 10 dígitos numéricos")
    String telefono,

    @Email(message = "El email debe tener un formato valido")
    @NotBlank(message = "El email es obligatorio")
    String email
) {}
