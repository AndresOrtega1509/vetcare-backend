package com.devsenior.vetcare.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.vetcare.dto.request.VeterinarioRequestDTO;
import com.devsenior.vetcare.dto.response.VeterinarioResponseDTO;
import com.devsenior.vetcare.exception.RecursoNoEncontradoException;
import com.devsenior.vetcare.exception.TarjetaProfesionalExistenteException;
import com.devsenior.vetcare.model.Veterinario;
import com.devsenior.vetcare.repository.VeterinarioRepository;
import com.devsenior.vetcare.service.IVeterinarioService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class VeterinarioService implements IVeterinarioService{
    private final VeterinarioRepository veterinarioRepository;

    @Override
    public VeterinarioResponseDTO crearVeterinario(VeterinarioRequestDTO veterinarioRequestDTO) {
        verificarTarjetaProfesionalUnica(veterinarioRequestDTO.tarjetaProfesional());
        Veterinario veterinarioCreado = mapToVeterinarioEntity(veterinarioRequestDTO);
        Veterinario veterinarioGuardado = veterinarioRepository.save(veterinarioCreado);
        return mapToVeterinarioResponseDTO(veterinarioGuardado);
    }

    @Override
    public List<VeterinarioResponseDTO> listarTodos() {
        return veterinarioRepository.findAll().stream()
                .map(this::mapToVeterinarioResponseDTO)
                .toList();
    }

    @Override
    public VeterinarioResponseDTO obtenerVeterinarioPorId(Long id) {
        Veterinario veterinarioEncontrado = verificarVeterinarioExistente(id);
        return mapToVeterinarioResponseDTO(veterinarioEncontrado);
    }

    @Override
    public VeterinarioResponseDTO actualizarVeterinario(Long id, VeterinarioRequestDTO veterinarioRequestDTO) {
        Veterinario veterinarioEncontrado = verificarVeterinarioExistente(id);
        verificarTarjetaProfesionalUnica(veterinarioRequestDTO.tarjetaProfesional());

        veterinarioEncontrado.setNombre(veterinarioRequestDTO.nombre());
        veterinarioEncontrado.setApellido(veterinarioRequestDTO.apellido());
        veterinarioEncontrado.setEspecialidad(veterinarioRequestDTO.especialidad());
        veterinarioEncontrado.setTarjetaProfesional(veterinarioRequestDTO.tarjetaProfesional());

        Veterinario veterinarioActualizado = veterinarioRepository.save(veterinarioEncontrado);
        return mapToVeterinarioResponseDTO(veterinarioActualizado);
    }

    @Override
    public void eliminarVeterinario(Long id) {
        Veterinario veterinarioEncontrado = verificarVeterinarioExistente(id);
        veterinarioRepository.delete(veterinarioEncontrado);
    }

    private Veterinario mapToVeterinarioEntity(VeterinarioRequestDTO veterinarioRequestDTO) {
        return Veterinario.builder()
                .nombre(veterinarioRequestDTO.nombre())
                .apellido(veterinarioRequestDTO.apellido())
                .especialidad(veterinarioRequestDTO.especialidad())
                .tarjetaProfesional(veterinarioRequestDTO.tarjetaProfesional())
                .build();
    }

    private VeterinarioResponseDTO mapToVeterinarioResponseDTO(Veterinario veterinario) {
        return VeterinarioResponseDTO.builder()
                .id(veterinario.getId())
                .nombre(veterinario.getNombre())
                .apellido(veterinario.getApellido())
                .especialidad(veterinario.getEspecialidad())
                .tarjetaProfesional(veterinario.getTarjetaProfesional())
                .build();
    }

    private void verificarTarjetaProfesionalUnica(String tarjetaProfesional) {
        if (veterinarioRepository.existsByTarjetaProfesional(tarjetaProfesional)) {
            throw new TarjetaProfesionalExistenteException(tarjetaProfesional);
        }
    }

    private Veterinario verificarVeterinarioExistente(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Veterinario", "ID", id));
    }

}
