package com.example.futbolcanchas.model;

import jakarta.persistence.*;
import lombok.Data;
//Setting Cancha Model
@Data
@Entity
@Table(name = "canchas")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "distrito_id", nullable = false)
    private Distrito distrito;

    @Column(nullable = false)
    private boolean disponible;
}
