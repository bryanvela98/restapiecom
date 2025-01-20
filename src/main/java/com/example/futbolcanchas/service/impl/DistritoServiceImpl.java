package com.example.futbolcanchas.service.impl;

import com.example.futbolcanchas.dto.DistritoDTO;
import com.example.futbolcanchas.mapper.DistritoMapper;
import com.example.futbolcanchas.model.Distrito;
import com.example.futbolcanchas.repository.DistritoRepository;
import com.example.futbolcanchas.service.DistritoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistritoServiceImpl implements DistritoService {

    private final DistritoRepository repository;
    private final DistritoMapper mapper;

    public DistritoServiceImpl(DistritoRepository repository, DistritoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DistritoDTO> getAllDistritos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DistritoDTO saveDistrito(DistritoDTO distritoDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(distritoDTO)));
    }

    @Override
    public DistritoDTO getDistritoByNombre(String nombre) {
        Distrito distrito = repository.findByNombre(nombre);
        return distrito != null ? mapper.toDTO(distrito) : null;
    }
}
