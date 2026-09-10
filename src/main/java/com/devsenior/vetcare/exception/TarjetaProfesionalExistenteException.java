package com.devsenior.vetcare.exception;

public class TarjetaProfesionalExistenteException extends RuntimeException {
    public TarjetaProfesionalExistenteException(String tarjetaProfesional) {
        super("La tarjeta profesional " + tarjetaProfesional + " ya está registrada.");
    }

}
