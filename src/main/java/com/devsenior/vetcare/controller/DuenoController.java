package com.devsenior.vetcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.vetcare.dto.request.DuenoRequestDTO;
import com.devsenior.vetcare.dto.response.DuenoResponseDTO;
import com.devsenior.vetcare.service.IDuenoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/api/duenos")
@RequiredArgsConstructor 
public class DuenoController {
    private final IDuenoService duenoService;

    @PostMapping
    public ResponseEntity<DuenoResponseDTO> crearDueno(@Valid @RequestBody DuenoRequestDTO duenoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(duenoService.crearDueno(duenoRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DuenoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(duenoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuenoResponseDTO> obtenerDuenoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(duenoService.obtenerDuenoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DuenoResponseDTO> actualizarDueno(@PathVariable Long id, @Valid @RequestBody DuenoRequestDTO duenoRequestDTO) {
        return ResponseEntity.ok(duenoService.actualizarDueno(id, duenoRequestDTO));
    }
    
    @DeleteMapping 
    public ResponseEntity<Void> eliminarDueno(@PathVariable Long id) {
        duenoService.eliminarDueno(id);
        return ResponseEntity.noContent().build();
    }
}
