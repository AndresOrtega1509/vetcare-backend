package com.devsenior.vetcare.exception;

public class DuenoNoEncontradoException extends RuntimeException {
    public DuenoNoEncontradoException(Long id) {
        super("Dueño con ID " + id + " no encontrado.");
    }
}
