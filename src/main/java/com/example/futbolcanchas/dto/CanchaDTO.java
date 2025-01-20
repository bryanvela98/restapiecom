package com.example.futbolcanchas.dto;

import lombok.Data;

@Data
public class CanchaDTO {
    private Long id;
    private String nombre;
    private String distrito;
    private boolean disponible;
}
