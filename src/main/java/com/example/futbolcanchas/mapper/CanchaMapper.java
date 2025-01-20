package com.example.futbolcanchas.mapper;

import com.example.futbolcanchas.dto.CanchaDTO;
import com.example.futbolcanchas.model.Cancha;
import com.example.futbolcanchas.model.Distrito;
import org.springframework.stereotype.Component;

@Component
public class CanchaMapper {

    public CanchaDTO toDTO(Cancha cancha) {
        CanchaDTO dto = new CanchaDTO();
        dto.setId(cancha.getId());
        dto.setNombre(cancha.getNombre());
        dto.setDistrito(cancha.getDistrito() != null ? cancha.getDistrito().getNombre() : null); 
        dto.setDisponible(cancha.isDisponible());
        return dto;
    }

    public Cancha toEntity(CanchaDTO dto, Distrito distrito) {
        Cancha cancha = new Cancha();
        cancha.setId(dto.getId());
        cancha.setNombre(dto.getNombre());
        cancha.setDistrito(distrito); 
        cancha.setDisponible(dto.isDisponible());
        return cancha;
    }

    public Cancha toEntity(CanchaDTO dto) {
        return toEntity(dto, null);
    }
}
