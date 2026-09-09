package com.devsenior.vetcare.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex, 
                                                                            HttpServletRequest httpRequest) {
        List<String> details =  ex.getBindingResult().getFieldErrors()
                                            .stream()
                                            .map(error -> formatError(error))
                                            .toList();

        ApiError errorResponse = ApiError.builder()
                                    .timestamp(LocalDateTime.now())
                                    .status(HttpStatus.BAD_REQUEST.value())
                                    .error("Error de validación")
                                    .message("Los datos proporcionados no son válidos")
                                    .details(details)
                                    .uri(httpRequest.getRequestURI())
                                    .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(EmailExistenteException.class)
    public ResponseEntity<ApiError> handleEmailAlreadyExistsException(EmailExistenteException ex, 
                                                                            HttpServletRequest httpRequest) {
        ApiError errorResponse = ApiError.builder()
                                    .timestamp(LocalDateTime.now())
                                    .status(HttpStatus.CONFLICT.value())
                                    .error("Email ya existe")
                                    .message(ex.getMessage())
                                    .uri(httpRequest.getRequestURI())
                                    .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(DocumentoExistenteException.class)
    public ResponseEntity<ApiError> handleDocumentoAlreadyExistsException(DocumentoExistenteException ex, 
                                                                            HttpServletRequest httpRequest) {
        ApiError errorResponse = ApiError.builder()
                                    .timestamp(LocalDateTime.now())
                                    .status(HttpStatus.CONFLICT.value())
                                    .error("Documento ya existe")
                                    .message(ex.getMessage())
                                    .uri(httpRequest.getRequestURI())
                                    .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(DuenoNoEncontradoException.class)
    public ResponseEntity<ApiError> handleDuenoNotFoundException(DuenoNoEncontradoException ex, 
                                                                            HttpServletRequest httpRequest) {
        ApiError errorResponse = ApiError.builder()
                                    .timestamp(LocalDateTime.now())
                                    .status(HttpStatus.NOT_FOUND.value())
                                    .error("Dueno no encontrado")
                                    .message(ex.getMessage())
                                    .uri(httpRequest.getRequestURI())
                                    .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalException(Exception ex,
                                                              HttpServletRequest httpRequest) {
        ApiError errorResponse = ApiError.builder()
                                    .timestamp(LocalDateTime.now())
                                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                    .error("Error interno del servidor")
                                    .message("Ocurrió un error inesperado en el servidor")
                                    .uri(httpRequest.getRequestURI())
                                    .build();
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    private String formatError(FieldError error) {
		return  error.getField() + ": " + error.getDefaultMessage();
	}
}
