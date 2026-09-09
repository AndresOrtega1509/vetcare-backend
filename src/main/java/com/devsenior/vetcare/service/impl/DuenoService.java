package com.devsenior.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.vetcare.dto.request.DuenoRequestDTO;
import com.devsenior.vetcare.dto.response.DuenoResponseDTO;
import com.devsenior.vetcare.model.Dueno;
import com.devsenior.vetcare.repository.DuenoRepository;
import com.devsenior.vetcare.service.IDuenoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor  
public class DuenoService implements IDuenoService {
    private final DuenoRepository duenoRepository;

    @Override
    public DuenoResponseDTO crearDueno(DuenoRequestDTO duenoRequestDTO) {
        validarDocumentoYEmail(duenoRequestDTO);
        Dueno duenoCreado = mapToDueno(duenoRequestDTO);
        Dueno duenoGuardado = duenoRepository.save(duenoCreado);
        return mapToDuenoResponseDTO(duenoGuardado);
    }

    @Override
    public List<DuenoResponseDTO> listarTodos() {
        return duenoRepository.findAll().stream()
                .map(this::mapToDuenoResponseDTO)
                .toList();
    }

    @Override
    public DuenoResponseDTO obtenerDuenoPorId(Long id) {
        Dueno duenoEncontrado = duenoRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException());
        return mapToDuenoResponseDTO(duenoEncontrado);
    }

    @Override
    public DuenoResponseDTO actualizarDueno(Long id, DuenoRequestDTO duenoRequestDTO) {
        Dueno duenoEncontrado = duenoRepository.findById(id)
                                                .orElseThrow(() -> new RuntimeException());
        validarDocumentoYEmail(duenoRequestDTO);
        
        duenoEncontrado.setNombre(duenoRequestDTO.nombre());
        duenoEncontrado.setApellido(duenoRequestDTO.apellido());
        duenoEncontrado.setDocumento(duenoRequestDTO.documento());
        duenoEncontrado.setTelefono(duenoRequestDTO.telefono());
        duenoEncontrado.setEmail(duenoRequestDTO.email());

        Dueno duenoActualizado = duenoRepository.save(duenoEncontrado);
        return mapToDuenoResponseDTO(duenoActualizado);
    }

    @Override
    public void eliminarDueno(Long id) {
        if (!duenoRepository.existsById(id)) {
            throw new RuntimeException();
        }
        duenoRepository.deleteById(id);
    }

    private Dueno mapToDueno(DuenoRequestDTO duenoRequestDTO) {
        return Dueno.builder()
                .nombre(duenoRequestDTO.nombre())
                .apellido(duenoRequestDTO.apellido())
                .documento(duenoRequestDTO.documento())
                .telefono(duenoRequestDTO.telefono())
                .email(duenoRequestDTO.email())
                .build();
    }

    private DuenoResponseDTO mapToDuenoResponseDTO(Dueno dueno) {
        return DuenoResponseDTO.builder()
                .id(dueno.getId())
                .nombre(dueno.getNombre())
                .apellido(dueno.getApellido())
                .documento(dueno.getDocumento())
                .telefono(dueno.getTelefono())
                .email(dueno.getEmail())
                .build();
    }

    private void validarDocumentoYEmail(DuenoRequestDTO duenoRequestDTO) {
        if (duenoRepository.existsByDocumento(duenoRequestDTO.documento())) {
            throw new RuntimeException("Ya existe el documento: " + duenoRequestDTO.documento());
        }
        if (duenoRepository.existsByEmail(duenoRequestDTO.email())) {
            throw new RuntimeException("Ya existe el email: " + duenoRequestDTO.email());
        }
    }
}
