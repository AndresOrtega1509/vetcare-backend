package com.devsenior.vetcare.service;

import java.util.List;

import com.devsenior.vetcare.dto.request.DuenoRequestDTO;
import com.devsenior.vetcare.dto.response.DuenoResponseDTO;

public interface IDuenoService {
    DuenoResponseDTO crearDueno(DuenoRequestDTO duenoRequestDTO);
    List<DuenoResponseDTO> listarTodos();
    DuenoResponseDTO obtenerDuenoPorId(Long id);
    DuenoResponseDTO actualizarDueno(Long id, DuenoRequestDTO duenoRequestDTO);
    void eliminarDueno(Long id);
}
