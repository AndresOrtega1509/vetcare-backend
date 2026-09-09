package com.devsenior.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.vetcare.model.Dueno;
import com.devsenior.vetcare.repository.DuenoRepository;
import com.devsenior.vetcare.service.IDuenoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  
public class DuenoService implements IDuenoService {
    private final DuenoRepository duenoRepository;

    @Override
    public List<Dueno> listarTodos() {
        return duenoRepository.findAll();
    }
}
