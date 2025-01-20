package com.example.futbolcanchas.mapper;

import com.example.futbolcanchas.dto.DistritoDTO;
import com.example.futbolcanchas.model.Distrito;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DistritoMapper {

    private final CanchaMapper canchaMapper;

    public DistritoMapper(CanchaMapper canchaMapper) {
        this.canchaMapper = canchaMapper;
    }

    public DistritoDTO toDTO(Distrito distrito) {
        DistritoDTO dto = new DistritoDTO();
        dto.setId(distrito.getId());
        dto.setNombre(distrito.getNombre());
        if (distrito.getCanchas() != null) {
            dto.setCanchas(distrito.getCanchas()
                    .stream()
                    .map(canchaMapper::toDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public Distrito toEntity(DistritoDTO dto) {
        Distrito distrito = new Distrito();
        distrito.setId(dto.getId());
        distrito.setNombre(dto.getNombre());
        return distrito;
    }
}
