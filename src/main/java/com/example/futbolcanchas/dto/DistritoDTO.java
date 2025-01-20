package com.example.futbolcanchas.dto;

import lombok.Data;

import java.util.List;

@Data
public class DistritoDTO {
    private Long id;
    private String nombre;
    private List<CanchaDTO> canchas;
}
