package com.example.futbolcanchas.repository;

import com.example.futbolcanchas.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {
    List<Cancha> findByDistrito_Nombre(String nombreDistrito);
}
