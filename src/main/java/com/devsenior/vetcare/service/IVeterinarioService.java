package com.devsenior.vetcare.service;

import java.util.List;

import com.devsenior.vetcare.dto.request.VeterinarioRequestDTO;
import com.devsenior.vetcare.dto.response.VeterinarioResponseDTO;

public interface IVeterinarioService {
    VeterinarioResponseDTO crearVeterinario(VeterinarioRequestDTO veterinarioRequestDTO);
    List<VeterinarioResponseDTO> listarTodos();
    VeterinarioResponseDTO obtenerVeterinarioPorId(Long id);
    VeterinarioResponseDTO actualizarVeterinario(Long id, VeterinarioRequestDTO veterinarioRequestDTO);
    void eliminarVeterinario(Long id);
}
