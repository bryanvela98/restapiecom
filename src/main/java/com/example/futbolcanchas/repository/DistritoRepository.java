package com.example.futbolcanchas.repository;

import com.example.futbolcanchas.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {
    Distrito findByNombre(String nombre);
}
