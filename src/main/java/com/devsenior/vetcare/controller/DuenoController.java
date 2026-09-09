package com.devsenior.vetcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.vetcare.model.Dueno;
import com.devsenior.vetcare.service.IDuenoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController 
@RequestMapping("/api/duenos")
@RequiredArgsConstructor 
public class DuenoController {
    private final IDuenoService duenoService;

    @GetMapping
    public ResponseEntity<List<Dueno>> listarTodos() {
        return ResponseEntity.ok(duenoService.listarTodos());
    }
}
