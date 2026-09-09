package com.devsenior.vetcare.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder 
public record ApiError(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    List<String> details,
    String uri
) {
    public ApiError {
        details = (details == null) ? List.of() : List.copyOf(details);
    }
}
