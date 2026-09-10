package com.devsenior.vetcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.vetcare.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    boolean existsByTarjetaProfesional(String tarjetaProfesional);
}
