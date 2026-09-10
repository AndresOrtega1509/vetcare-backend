package com.devsenior.vetcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.vetcare.dto.request.VeterinarioRequestDTO;
import com.devsenior.vetcare.dto.response.VeterinarioResponseDTO;
import com.devsenior.vetcare.service.IVeterinarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/api/veterinarios")
@RequiredArgsConstructor 
public class VeterinarioController {
    private final IVeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<VeterinarioResponseDTO> crearVeterinario(@Valid @RequestBody VeterinarioRequestDTO veterinarioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioService.crearVeterinario(veterinarioRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioResponseDTO>> listarVeterinarios() {
        return ResponseEntity.ok(veterinarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioResponseDTO> obtenerVeterinarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veterinarioService.obtenerVeterinarioPorId(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioResponseDTO> actualizarVeterinario(@PathVariable Long id, @Valid @RequestBody VeterinarioRequestDTO veterinarioRequestDTO) {
        return ResponseEntity.ok(veterinarioService.actualizarVeterinario(id, veterinarioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long id) {
        veterinarioService.eliminarVeterinario(id);
        return ResponseEntity.noContent().build();
    }
}
