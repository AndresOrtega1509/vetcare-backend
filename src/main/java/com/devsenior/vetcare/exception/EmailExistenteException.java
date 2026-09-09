package com.devsenior.vetcare.exception;

public class EmailExistenteException extends RuntimeException {
    public EmailExistenteException(String message) {
        super("Ya existe el email: " + message);
    }

}
