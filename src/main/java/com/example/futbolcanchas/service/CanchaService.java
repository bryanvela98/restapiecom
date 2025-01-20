package com.example.futbolcanchas.service;

import com.example.futbolcanchas.dto.CanchaDTO;

import java.util.List;

public interface CanchaService {
    List<CanchaDTO> getCanchasByDistrito(String distrito);
    CanchaDTO saveCancha(CanchaDTO canchaDTO);
}
