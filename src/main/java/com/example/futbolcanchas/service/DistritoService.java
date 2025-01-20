package com.example.futbolcanchas.service;

import com.example.futbolcanchas.dto.DistritoDTO;

import java.util.List;

public interface DistritoService {
    List<DistritoDTO> getAllDistritos();
    DistritoDTO saveDistrito(DistritoDTO distritoDTO);
    DistritoDTO getDistritoByNombre(String nombre);
}
