package com.devsenior.vetcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.vetcare.model.Dueno;


public interface DuenoRepository extends JpaRepository<Dueno, Long> {
    Optional<Dueno> findByEmail(String email);
}
