package com.devsenior.vetcare.exception;

public class DocumentoExistenteException extends RuntimeException {
    public DocumentoExistenteException(String message) {
        super("Ya existe el documento: " + message);
    }

}
