package com.example.futbolcanchas.service.impl;

import com.example.futbolcanchas.dto.CanchaDTO;
import com.example.futbolcanchas.mapper.CanchaMapper;
import com.example.futbolcanchas.repository.CanchaRepository;
import com.example.futbolcanchas.service.CanchaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CanchaServiceImpl implements CanchaService {

    private final CanchaRepository repository;
    private final CanchaMapper mapper;

    public CanchaServiceImpl(CanchaRepository repository, CanchaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<CanchaDTO> getCanchasByDistrito(String distrito) {
        // Se usa el método findByDistrito_Nombre para obtener las canchas por nombre de distrito
        return repository.findByDistrito_Nombre(distrito)
                .stream()
                .map(mapper::toDTO) 
                .collect(Collectors.toList());
    }

    @Override
    public CanchaDTO saveCancha(CanchaDTO canchaDTO) {
        // Guarda la nueva cancha y la convierte de nuevo a DTO antes de devolverla
        return mapper.toDTO(repository.save(mapper.toEntity(canchaDTO)));
    }
}
